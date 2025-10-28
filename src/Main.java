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
                    System.out.println(AppConstants.MODE_CAESAR);

                    System.out.println(AppConstants.INPUT_FILE);
                    String fileName = console.nextLine();

                    System.out.println(AppConstants.SELECTION_OPERATION);
                    char operations = console.next().charAt(0);

                    System.out.println(AppConstants.INPUT_KEY);
                    int key = console.nextInt();

                    caesarCipher.encryptFile(fileName, key, operations, AppConstants.ENCRYPTION_MODE_CAESAR);
                    System.out.println(AppConstants.PROCESS_COMPLETE);
                    break;

                case "2":
                    System.out.println(AppConstants.BRUTEFORCE_MODE_LABEL);
                    System.out.println(AppConstants.INPUT_FILE);

                    String fileName2 = console.nextLine();
                    caesarCipher.bruteForceDecrypt(fileName2);
                    break;
                case "3":
                    isActive = false;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        console.close();

    }
}
