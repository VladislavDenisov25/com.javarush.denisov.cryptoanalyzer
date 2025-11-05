package app;

import constants.AppConstants;
import service.*;

import java.util.Scanner;

public class MenuHandler {

    private final CaesarCipherService caesarCipher = new CaesarCipherService();
    private final StaticAnalysisService staticAnalysis = new StaticAnalysisService();
    private final BruteForceService bruteForce = new BruteForceService();

    private final Scanner console = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println(AppConstants.MAIN_MENU);

            int numberMenu = Integer.parseInt(console.nextLine());

            switch (numberMenu) {
                case 1 -> encrypt(true);
                case 2 -> encrypt(false);
                case 3 -> bruteForse();
                case 4 -> statAnalysis();
                case 0 -> System.out.println(AppConstants.GOOD_BAY);
                default -> System.out.println(AppConstants.INVALID_INPUT);
            }
        }
    }

    public void encrypt(boolean isEncrypt) {

        String fileName = readNameFile(AppConstants.INPUT_FILE);
        int key = readInt(AppConstants.INPUT_KEY);

        caesarCipher.encryption(fileName, key, isEncrypt);

    }

    public void bruteForse() {

        String fileName = readNameFile(AppConstants.INPUT_FILE);

        bruteForce.bruteForceDecrypt(fileName);
    }

    public void statAnalysis() {
        String fileName = readNameFile(AppConstants.INPUT_FILE);
        staticAnalysis.decrypt(fileName);

    }

    public int readInt(String string) {

        while (true) {
            try {
                System.out.print(string);
                return Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(AppConstants.ERROR_FORMAT_VALUE);
            }
        }
    }

    public String readNameFile(String string) {

        System.out.print(string);
        return console.nextLine();
    }
}
