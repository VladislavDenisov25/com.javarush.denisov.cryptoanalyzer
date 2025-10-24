package service;

import util.*;

import java.io.*;


public class CaesarCipherService {

    private static final char[] CHARS_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    private static final int CHAR_LENGTH = CHARS_ALPHABET.length;


    public char[] encryption(String fileName, int key, char operation) {

        char[] fileText = FileHandlerUtil.readFile(fileName);
        int bias = Math.abs(key % CHAR_LENGTH);

        char[] result = new char[fileText.length];

        for (int i = 0; i < fileText.length; i++) {
            char nextChar = fileText[i];
            int number = indexSearch(nextChar);

            if (number != -1) {
                int index = number + operation + bias;
                if (index > CHAR_LENGTH - 1) {
                    index = Math.abs(CHAR_LENGTH - index);
                }
                nextChar = CHARS_ALPHABET[index];
            }
            result[i] = nextChar;
        }

        return result;
    }


//    public void bruteForce(File file, char[] chars) {
//        FileHandlerUtil fileHandler  = new FileHandlerUtil();
//
//        for (int i = 0; i < CHAR_LENGTH; i++) {
//
//            fileHandler.creatNameBruteForceFile(file, encryption(chars, i), i);//
//        }
//    }


    public int indexSearch(char chr) {

        for (int i = 0; i < CHAR_LENGTH; i++) {
            char chars = CHARS_ALPHABET[i];
            if (chars == chr) {
                return i;
            }
        }
        return -1;
    }


}
