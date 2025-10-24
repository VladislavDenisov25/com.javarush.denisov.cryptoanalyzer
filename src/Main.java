import constants.AppConstants;
import service.CaesarCipherService;
import util.FileHandlerUtil;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        CaesarCipherService caesarCipher = new CaesarCipherService();



        Scanner console = new Scanner(System.in);

        boolean isActive = true;

        System.out.println("Добро пожаловать!");

        while (isActive) {
            System.out.println(AppConstants.mainMenu);
            switch (console.nextLine()) {
                case "1":
                    System.out.println(AppConstants.mainMenu1);

                    System.out.println(AppConstants.mainMenuFile);
                    String fileName = console.nextLine();

                    System.out.println(AppConstants.selection);
                    char operations = console.next().charAt(0);

                    System.out.println("Укажите ключ");
                    int key = console.nextInt();

                    caesarCipher.encryption(fileName, key, operations);

                    break;
                case "2" :
                    System.out.println(AppConstants.mainMenu2);
                    System.out.println(AppConstants.mainMenuFile);

                    File file3 = new File(console.nextLine()); // не тут просто стринг

                    char[] chars3 = fileHandler.readFile(file3); // не тут
                    caesarCipher.bruteForce(file3, chars3);
                    break;
                case "3":
                    isActive = false;
                    break;
                default:
                    System.out.println("Неверный ввод!\n\n");
            }




        }
        console.close();


    }

}
