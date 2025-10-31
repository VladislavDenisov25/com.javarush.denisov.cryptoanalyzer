package constants;

public interface AppConstants {

       String MAIN_MENU = """
               
               Выберите режим работы:
               1. Зашифровать текст.
               2. Расшифровать текст (нужен ключ).
               3. Взлом методом \"brute force\".
               4. Взлом методом \"статич. анализа\".
               0. Выход.""";



       String INPUT_FILE = "Укажите путь к файлу:";
       String INPUT_KEY = "Укажите ключ:";
       String INVALID_INPUT = "Неверный ввод!\n";


       String PROCESS_COMPLETE = "Процесс шифрования завершен, имя файла \"encryptedFile\"";
       String ENCRYPTION_MODE_CAESAR = "caesar";
       String ENCRYPTION_MODE_BRUTEFORCE = "bruteforse";

       String FILE_NAME_ENCRYPTED = "encryptedFile.txt";
       String FILE_NAME_DECRYPTED = "decryptionFile.txt";
       String FILE_NAME_BRUTFORSE = "BruteForceFile";
       String DIRECTORY_BRUTEFORCE = "BruteForceFiles";
       String EXTENSION = ".txt";

       String ERROR_UNEXPECTED_VALUE = "Unexpected value: ";
       String ERROR_FILE_NOT_FOUND = "Файл не существует или неправильно указан путь к файлу";
       String ERROR_INVALID_OUTPUT_PATH = "Некорректно указан путь к результирующему файлу";
       String ERROR_CREAT_FILE_BRUTFORSE = "Ошибка при создании файла для brute-force: ";
}
