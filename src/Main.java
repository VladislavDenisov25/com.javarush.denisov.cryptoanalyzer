import constants.AppConstants;
import service.CaesarCipherService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        CaesarCipherService caesarCipher = new CaesarCipherService();

        Scanner console = new Scanner(System.in);

        boolean isActive = true;

        System.out.println(AppConstants.WELCOME);

        while (isActive) {
            System.out.println(AppConstants.MAIN_MENU);
            switch (console.nextLine()) {
                case "1":

                    System.out.println(AppConstants.INPUT_FILE);
                    String fileName = console.nextLine();

                    System.out.println(AppConstants.INPUT_KEY);
                    int key = console.nextInt();

                    caesarCipher.encryptFile(fileName, key, true, AppConstants.ENCRYPTION_MODE_CAESAR);
                    System.out.println(AppConstants.PROCESS_COMPLETE);
                    break;
                case "2":


                    System.out.println(AppConstants.INPUT_FILE);
                    String fileName1 = console.nextLine();

                    System.out.println(AppConstants.INPUT_KEY);
                    int key1 = console.nextInt();

                    caesarCipher.encryptFile(fileName1, key1, false, AppConstants.ENCRYPTION_MODE_CAESAR);
                    System.out.println(AppConstants.PROCESS_COMPLETE);
                    break;
                case "3":

                    System.out.println(AppConstants.INPUT_FILE);

                    String fileName2 = console.nextLine();
                    caesarCipher.bruteForceDecrypt(fileName2);
                    break;
                case "4":



                    break;
                case "0":
                    isActive = false;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }

        }
        console.close();

    }
}
