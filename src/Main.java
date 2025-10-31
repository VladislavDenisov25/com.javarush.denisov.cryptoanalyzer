import constants.AppConstants;
import service.CaesarCipherService;

import java.util.Scanner;


public class Main {

   private static final  CaesarCipherService caesarCipher = new CaesarCipherService();

   private static final  Scanner console = new Scanner(System.in);


    public static void main(String[] args) {







        while (true) {

            System.out.println(AppConstants.MAIN_MENU);

            int numberMenu = Integer.parseInt(console.nextLine());

            switch (numberMenu) {
                case 1:
                    String fileName = readNameFile(AppConstants.INPUT_FILE);
                    int key = readInt(AppConstants.INPUT_KEY);

                    caesarCipher.encryptFile(fileName, key, true, AppConstants.ENCRYPTION_MODE_CAESAR);
                    System.out.println(AppConstants.PROCESS_COMPLETE);

                    break;
                case 2:
                    System.out.println(AppConstants.INPUT_FILE);
                    String fileName1 = console.nextLine();

                    System.out.println(AppConstants.INPUT_KEY);
                    int key1 = console.nextInt();

                    caesarCipher.encryptFile(fileName1, key1, false, AppConstants.ENCRYPTION_MODE_CAESAR);
                    System.out.println(AppConstants.PROCESS_COMPLETE);
                    break;
                case 3:

                    System.out.println(AppConstants.INPUT_FILE);

                    String fileName2 = console.nextLine();
                    caesarCipher.bruteForceDecrypt(fileName2);
                    break;
                case 4:



                    break;
                case 0:
                    return;
                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }

        }



    }

    public static int readInt(String string) {

        while (true) {
            try {
                System.out.print(string);
                return Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    public static String readNameFile(String string) {
        System.out.print(string);
        return console.nextLine();
    }

}
