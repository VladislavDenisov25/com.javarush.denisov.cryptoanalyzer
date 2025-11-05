package service;

import util.*;

public class CaesarCipherService extends Alphabet {

    FileHandlerUtil fileHandler = new FileHandlerUtil();

    public char[] charOffset(char[] oldChars, int key, boolean isEncrypt) {

        char[] newChars = new char[oldChars.length];

        for (int i = 0; i < oldChars.length; i++) {
            int charIndex = findCharIndex(oldChars[i]);

            if (charIndex != -1) {
                int shiftedIndex = calculateShift(charIndex, key, isEncrypt);
                newChars[i] = getAlphabet()[shiftedIndex];
            } else {
                newChars[i] = oldChars[i];
            }
        }
        return newChars;
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

    public void encryption(String fileName, int key, boolean isEncrypt) {

        char[] fileText = FileHandlerUtil.readFile(fileName);
        char[] newText = charOffset(fileText, key, isEncrypt);

        fileHandler.createEncryptedFile(fileName, newText, isEncrypt);
    }
}
