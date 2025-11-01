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
                case 1 -> encrypt(true);
                case 2 -> encrypt(false);
                case 3 -> bruteForse();
                case 4 -> System.out.println();
                case 0 -> System.out.println("Всего хорошего!");
                default -> System.out.println(AppConstants.INVALID_INPUT);
            }

        }



    }

    public static void bruteForse(){
        System.out.println(AppConstants.INPUT_FILE);

        String fileName2 = console.nextLine();
        caesarCipher.bruteForceDecrypt(fileName2);
    }



    public static void encrypt(boolean isEncrypt){
        String fileName = readNameFile(AppConstants.INPUT_FILE);
        int key = readInt(AppConstants.INPUT_KEY);

        caesarCipher.encryptFile(fileName, key, isEncrypt, AppConstants.ENCRYPTION_MODE_CAESAR);

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
