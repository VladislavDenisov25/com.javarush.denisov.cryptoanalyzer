import constants.AppConstants;
import service.CaesarCipherService;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        CaesarCipherService caesarCipher = new CaesarCipherService();



        Scanner console = new Scanner(System.in);

        boolean isActive = true;

        System.out.println(AppConstants.mainHello);

        while (isActive) {
            System.out.println(AppConstants.mainMenu);
            switch (console.nextLine()) {
                case "1":
                    System.out.println(AppConstants.mainMenu1);

                    System.out.println(AppConstants.mainMenuFile);
                    String fileName = console.nextLine();

                    System.out.println(AppConstants.selectionOperation);
                    char operations = console.next().charAt(0);

                    System.out.println(AppConstants.selectKey);
                    int key = console.nextInt();

                    caesarCipher.encryption(fileName, key, operations);
                    System.out.println(AppConstants.finalOperations);
                    break;

                case "2" :
                    System.out.println(AppConstants.mainMenu2);
                    System.out.println(AppConstants.mainMenuFile);

                    String fileName2 = console.nextLine();


          //         caesarCipher.bruteForce(fileName2);
                    break;
                case "3":
                    isActive = false;
                    break;
                default:
                    System.out.println(AppConstants.erorInput);
            }




        }
        console.close();


    }

}
