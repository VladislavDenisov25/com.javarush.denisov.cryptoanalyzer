package service;

import util.FileHandlerUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StaticAnalysisService {

    private char[] fileText;

    private static final TreeMap<Double, Character> FREQUENCY_CHARS_FILE = new TreeMap<>();

    private static final HashMap<Character, Double> FREQUENCY_CHARS = new HashMap<>() {{
        put(' ', 14.46);
        put('о', 9.42);
        put('е', 7.33);
        put('и', 6.72);
        put('а', 6.52);
        put('н', 5.83);
        put('т', 5.56);

    }};

    public void staticAtac(String fileName) {

        fileText = FileHandlerUtil.readFile(fileName);
        for (char c : fileText) {
            if (!locatedHasMap(c)) {
                double proc = proccentInput(c);
                FREQUENCY_CHARS_FILE.put(proc, c);
            }
        }
        biasKey(fileName);
    }

    public boolean locatedHasMap(char nextChar) {
        return FREQUENCY_CHARS_FILE.containsValue(nextChar);
    }

    public void biasKey(String fileName) {
        for (Map.Entry<Double, Character> entry : FREQUENCY_CHARS_FILE.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public double proccentInput(char nextChar) {
        int resultCount = 0;
        for (char c : fileText) {
            if (c == nextChar) {
                resultCount++;
            }
        }
        double procent = (resultCount * 1.0 / fileText.length) * 100;
   //     procent = new BigDecimal(procent).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return procent;
    }
}
