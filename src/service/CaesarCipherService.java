package service;

import util.*;

import java.io.*;
import java.lang.runtime.SwitchBootstraps;


public class CaesarCipherService {
    FileHandlerUtil handlerUtil = new FileHandlerUtil();

    private static final char[] CHARS_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    private static final int CHAR_LENGTH = CHARS_ALPHABET.length;


    public void encryption(String fileName, int key, char operation) {

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
                }
                nextChar = CHARS_ALPHABET[index];
            }
            result[i] = nextChar;
        }

       handlerUtil.creatNameEncryptedFile(fileName, result);
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

    public int operation(int a, int b, char operation){


          int  index = switch(operation){
                case '+' -> a + b;
                case '-' -> a - b;
              default -> throw new IllegalStateException("Unexpected value: " + operation);
          };

        return index;
    }


}
