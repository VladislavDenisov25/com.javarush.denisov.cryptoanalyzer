package service;

import constants.AppConstants;
import util.*;


public class CaesarCipherService {
    FileHandlerUtil handlerUtil = new FileHandlerUtil();

    private static final char[] CHARS_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    private static final int CHAR_LENGTH = CHARS_ALPHABET.length;

    public void encryption(String fileName, int key, char operation, String mode) {

        char[] fileText = FileHandlerUtil.readFile(fileName);
        int bias = Math.abs(key % CHAR_LENGTH);

        char[] result = new char[fileText.length];

        for (int i = 0; i < fileText.length; i++) {
            char nextChar = fileText[i];
            int number = indexSearch(nextChar);

            if (number != -1) {
                int index = operation(number, bias, operation);
                if (index > CHAR_LENGTH - 1) {
                    index = Math.abs(CHAR_LENGTH - index);
                } else if (index < 0) {
                    index = Math.abs(CHAR_LENGTH + index);
                }
                nextChar = CHARS_ALPHABET[index];
            }
            result[i] = nextChar;
        }
        if (mode.equalsIgnoreCase(AppConstants.modeCaesar)) {
            handlerUtil.creatNameEncryptedFile(fileName, result, operation);
        } else if (mode.equalsIgnoreCase(AppConstants.modeBruteforse)) {
            handlerUtil.creatNameBruteForceFile(fileName, result, key);
        }
    }

    public void bruteforce(String fileName) {

        for (int i = 0; i < CHAR_LENGTH; i++) {
            encryption(fileName, i, '+', AppConstants.modeBruteforse);
        }
    }

    public int indexSearch(char chr) {

        for (int i = 0; i < CHAR_LENGTH; i++) {
            char chars = CHARS_ALPHABET[i];
            if (chars == chr) {
                return i;
            }
        }
        return -1;
    }

    public int operation(int a, int b, char operation) {

        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            default -> throw new IllegalStateException(AppConstants.exception1 + operation);
        };
    }
}
