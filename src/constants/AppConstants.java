package constants;

public interface AppConstants {

       String mainMenu = """
               
               
               Выберите режим работы:
               
               1 - метод шифр Цезаря.
               2 - метод перебора Брутфорс.
               3 - для выхода из программы.""";

       String mainMenu1 = "Режим Цезарь!";
       String mainMenu2 = "Режим Брутфорс!";
       String mainMenuFile = "Укажите путь к файлу.";
       String selectionOperation = "Чтобы расшифровать введите \"-\" зашифровать \"+\"";
       String selectKey = "Укажите ключ";
       String mainHello = "Добро пожаловать!";
       String erorInput = "Неверный ввод!\n\n";
       String finalOperations = "Процесс шифрования завершен, имя файла \"encryptedFile\"";
       String modeCaesar = "caesar";
       String modeBruteforse = "bruteforse";
}
