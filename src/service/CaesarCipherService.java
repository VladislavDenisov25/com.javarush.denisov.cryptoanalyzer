package service;

import constants.AppConstants;
import util.*;


public class CaesarCipherService extends Alphabet{


    FileHandlerUtil fileHandlerUtil = new FileHandlerUtil();





    public char[] encryptFile(String fileName, int key, boolean isEncrypt, String mode) {

        char[] fileText = FileHandlerUtil.readFile(fileName);
        char[] result = new char[fileText.length];

        for (int i = 0; i < fileText.length; i++) {
            int charIndex = findCharIndex(fileText[i]);

            if (charIndex != -1) {
                int shiftedIndex = calculateShift(charIndex, key, isEncrypt);
                result[i] = getAlphabet()[shiftedIndex];
            } else {
                result[i] = fileText[i];
            }
        }
//        if (mode.equalsIgnoreCase(AppConstants.ENCRYPTION_MODE_CAESAR)) {
//            fileHandlerUtil.createEncryptedFile(fileName, result, isEncrypt);
//        } else if (mode.equalsIgnoreCase(AppConstants.ENCRYPTION_MODE_BRUTEFORCE)) {
//            fileHandlerUtil.createBruteForceFile(fileName, result, key);
//        }
        return result;
    }

    public void bruteForceDecrypt(String fileName) {

        for (int key = 0; key < getAlphabetLength(); key++) {
            encryptFile(fileName, key, true, AppConstants.ENCRYPTION_MODE_BRUTEFORCE);
        }
    }

    public int findCharIndex(char chr) {

        for (int i = 0; i < getAlphabetLength(); i++) {
            if (getAlphabet()[i] == chr) {
                return i;
            }
        }
        return -1;
    }

    public int calculateShift(int baseIndex, int key, boolean isEcrypt) {
        int bias = Math.abs(key % getAlphabetLength());
        return switch (isEcrypt) {
            case true -> (baseIndex + bias) % getAlphabetLength();
            case false -> (baseIndex - bias + getAlphabetLength()) % getAlphabetLength();
        };
    }


}
