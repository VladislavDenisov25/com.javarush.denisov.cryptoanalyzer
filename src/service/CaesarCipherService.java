package service;

import constants.AppConstants;
import util.*;


public class CaesarCipherService {

    FileHandlerUtil fileHandlerUtil = new FileHandlerUtil();

    private static final char[] CHARS_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    private static final int CHAR_LENGTH = CHARS_ALPHABET.length;

    public void encryptFile(String fileName, int key, boolean isEncrypt, String mode) {

        char[] fileText = FileHandlerUtil.readFile(fileName);
        int bias = Math.abs(key % CHAR_LENGTH);

        char[] result = new char[fileText.length];

        for (int i = 0; i < fileText.length; i++) {
            char currentChar = fileText[i];
            int charIndex = findCharIndex(currentChar);

            if (charIndex != -1) {
                int shiftedIndex = calculateShift(charIndex, bias, isEncrypt);
                result[i] = CHARS_ALPHABET[shiftedIndex];
            } else {
                result[i] = currentChar;
            }
        }
        if (mode.equalsIgnoreCase(AppConstants.ENCRYPTION_MODE_CAESAR)) {
            fileHandlerUtil.createEncryptedFile(fileName, result, isEncrypt);
        } else if (mode.equalsIgnoreCase(AppConstants.ENCRYPTION_MODE_BRUTEFORCE)) {
            fileHandlerUtil.createBruteForceFile(fileName, result, key);
        }
    }

    public void bruteForceDecrypt(String fileName) {

        for (int key = 0; key < CHAR_LENGTH; key++) {
            encryptFile(fileName, key, true, AppConstants.ENCRYPTION_MODE_BRUTEFORCE);
        }
    }

    public int findCharIndex(char chr) {

        for (int i = 0; i < CHAR_LENGTH; i++) {
            if (CHARS_ALPHABET[i] == chr) {
                return i;
            }
        }
        return -1;
    }

    public int calculateShift(int baseIndex, int bias, boolean isEcrypt) {

        return switch (isEcrypt) {
            case true -> (baseIndex + bias) % CHAR_LENGTH;
            case false -> (baseIndex - bias + CHAR_LENGTH) % CHAR_LENGTH;
        };
    }
}
