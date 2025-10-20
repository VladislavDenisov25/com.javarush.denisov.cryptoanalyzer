import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CaesarСipher caesarСipher = new CaesarСipher();
        FileHandler fileHandler = new FileHandler();


        Scanner console = new Scanner(System.in);

        boolean isActive = true;
        while (isActive) {
            System.out.println("Добро пожаловать!\n\nВыберите режим работы:\n1 - зашифровать текст.\n2 - расшифровать текст.\n3 - для выхода из программы.");
            switch (console.nextLine()) {
                case "1":
                    System.out.println("Режим шифрования!");
                    System.out.println("Укажите путь к файлу который нужно зашифровать");
                    File file = new File(console.nextLine());
                    System.out.println("Ваш файл - " + file);
                    System.out.println("Укажите смещение ключа для шифрования");
                    int number = console.nextInt();
                    System.out.println("Смещение ключа равно - " + number + "\n");
                    fileHandler.encryptedFile(file, caesarСipher.encryption(file, number));
                    break;
                case "2":
                    System.out.println("Режим дешифрования!");
                    System.out.println("Укажите путь к файлу который нужно дешифровать");
                    File file2 = new File(console.nextLine());
                    System.out.println("Ваш файл - " + file2);
                    System.out.println("Укажите смещение ключа для дешифрования");
                    int number2 = console.nextInt();
                    console.nextLine();
                    System.out.println("Смещение ключа равно - " + number2 + "\n");
                    fileHandler.decryptedFile(file2, caesarСipher.decryption(file2, number2));
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
