package service;

import util.FileHandlerUtil;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StaticAnalysisService {

    private char[] fileText;

    private static final HashMap<Character, Double> FREQUENCY_CHARS_FILE = new HashMap<>();

    private static final HashMap<Character, Double> FREQUENCY_CHARS = new HashMap<>() {{
        put(' ', 0.175);
        put('о', 0.090);
        put('е', 0.072);
        put('и', 0.062);
        put('а', 0.062);
        put('н', 0.053);
        put('т', 0.053);
    }};

    public void staticAtac(String fileName) {

        fileText = FileHandlerUtil.readFile(fileName);
        for (char c : fileText) {
            if (!locatedHasMap(c)) {
                double proc = proccentInput(c);
                FREQUENCY_CHARS_FILE.put(c, proc);
            }
        }
        biasKey(fileName);
    }

    public boolean locatedHasMap(char nextChar) {
        return FREQUENCY_CHARS_FILE.containsKey(nextChar);
    }

    public void biasKey(String fileName) {
        for (Map.Entry<Character, Double> entry : FREQUENCY_CHARS_FILE.entrySet()) {
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
        double procent = (resultCount * 1.0 / fileText.length) ;


        return (double) Math.round(procent * 1000) / 1000;
    }
}
