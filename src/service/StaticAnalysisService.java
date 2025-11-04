package service;


import constants.AppConstants;
import util.FileHandlerUtil;

import java.util.*;

public class StaticAnalysisService {
   static CaesarCipherService caesarCipherService = new CaesarCipherService();

    private char[] chars;


    private final HashMap<Character, Double> FREQUENCY_CHARS = new HashMap<>() {{
        put(' ', 0.175);
        put('о', 0.090);
        put('е', 0.072);
        put('и', 0.062);
        put('а', 0.062);
        put('н', 0.053);
        put('т', 0.053);
    }};

    public HashMap<Character, Double> calculateFrequency(String fileText) {

        HashMap<Character, Double> frequencyCharsFile = new HashMap<>();
         chars = FileHandlerUtil.readFile(fileText);
        for (char c : chars) {
            if (!frequencyCharsFile.containsKey(c)) {
                double proc = proccentInput(c);
                frequencyCharsFile.put(c, proc);
            }
        }

        return frequencyCharsFile;
    }

    public double proccentInput(char nextChar) {
        int resultCount = 0;
        for (char c : chars) {
            if (c == nextChar) {
                resultCount++;
            }
        }
        double procent = (resultCount * 1.0 / chars.length);

        return (double) Math.round(procent * 1000) / 1000;
    }


    public void decrypt(String text) {

        HashMap<Character, Double> freqDecrypted = calculateFrequency(text);

        int bestKey = -1;
        double bestDistance = Double.MAX_VALUE;

        for (int i = 0; i < caesarCipherService.CHAR_LENGTH; i++) {


            double distance = calculateFrequencyDistance(freqDecrypted, i); // ширина

            if (distance < bestDistance) {
                bestDistance = distance;
                bestKey = i;
            }
        }
        System.out.printf("Ключ для расшифровки - %d, ширина - %f\n", bestKey, bestDistance);
        caesarCipherService.encryptFile(text, bestKey, false, AppConstants.ENCRYPTION_MODE_CAESAR);

    }

    public  double calculateFrequencyDistance(HashMap<Character, Double> encryptionFile, int key) {
            double dist = 0.0;

        for (Map.Entry<Character, Double> entry : FREQUENCY_CHARS.entrySet()) {
            char keys = entry.getKey();
            double value = entry.getValue();

            char decrypt = encrypt(keys, key);
            double activDist = encryptionFile.getOrDefault(decrypt, 0.0);

            dist += Math.pow(value - activDist, 2);

        }
        return Math.sqrt(dist);
    }

    public static char encrypt(char oldChar, int key){
        char result;
       int indexOld = caesarCipherService.findCharIndex(oldChar);
       int newIndex = (indexOld + key) % caesarCipherService.getCharsAlphabet().length;
        result = caesarCipherService.getCharsAlphabet()[newIndex];
        return result;
    }


}
