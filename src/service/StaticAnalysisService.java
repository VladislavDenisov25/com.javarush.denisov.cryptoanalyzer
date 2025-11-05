package service;

import util.FileHandlerUtil;
import java.util.*;

public class StaticAnalysisService extends Alphabet {

    private CaesarCipherService caesarCipher = new CaesarCipherService();

    private final HashMap<Character, Double> FREQUENCY_CHARS = new HashMap<>() {{
        put(' ', 0.175);
        put('о', 0.090);
        put('е', 0.072);
        put('и', 0.062);
        put('а', 0.062);
        put('н', 0.053);
        put('т', 0.053);
    }};

    public void decrypt(String text) {  // имя зашифрованного файла

        HashMap<Character, Double> freqDecrypted = calculateFrequency(text);

        int bestKey = -1;
        double bestDistance = Double.MAX_VALUE;

        for (int i = 0; i < getAlphabetLength(); i++) {

            double distance = calculateFrequencyDistance(freqDecrypted, i); // ширина

            if (distance < bestDistance) {
                bestDistance = distance;
                bestKey = i;
            }
        }
        // System.out.printf("Ключ для расшифровки - %d, ширина - %f\n", bestKey, bestDistance); // не здесь
        caesarCipher.encryption(text, bestKey, false);
    }

    public HashMap<Character, Double> calculateFrequency(String fileText) {

        HashMap<Character, Integer> quantity = new HashMap<>();
        HashMap<Character, Double> frequencies = new HashMap<>();

        char[] chars = FileHandlerUtil.readFile(fileText);

        for (char c : chars) {
            quantity.put(c, quantity.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : quantity.entrySet()) {
            frequencies.put(entry.getKey(), (double) entry.getValue());
        }
        return frequencies;
    }

    public double calculateFrequencyDistance(HashMap<Character, Double> encryptionFile, int key) {
        double dist = 0.0;

        for (Map.Entry<Character, Double> entry : FREQUENCY_CHARS.entrySet()) {

            char keys = entry.getKey();
            double value = entry.getValue();

            char decrypt = caesarCipher.charOffset(new char[]{keys}, key, true)[0];
            double activDist = encryptionFile.getOrDefault(decrypt, 0.0);

            dist += Math.pow(value - activDist, 2);

        }
        return Math.sqrt(dist);
    }
}
