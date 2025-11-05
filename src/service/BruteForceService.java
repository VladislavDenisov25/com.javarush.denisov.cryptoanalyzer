package service;

import util.FileHandlerUtil;

public class BruteForceService extends Alphabet {

    private CaesarCipherService ccService = new CaesarCipherService();
    private FileHandlerUtil fileHandler = new FileHandlerUtil();

    public void bruteForceDecrypt(String fileName) {

        char[] oldChars = fileHandler.readFile(fileName);

        for (int key = 0; key < getAlphabetLength(); key++) {

            char[] encryptedChars = ccService.charOffset(oldChars, key, true);
            fileHandler.createBruteForceFile(fileName, encryptedChars, key);
        }
    }
}
