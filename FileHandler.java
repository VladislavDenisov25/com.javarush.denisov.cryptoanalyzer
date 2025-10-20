import java.io.*;
import java.nio.file.Path;

class FileHandler {

    private static int countFile;

    public FileHandler() {
        countFile++;
    }

    public void creatNameEncryptedFile(File file, char[] chars) {


        Path parentDirectory = file.toPath().getParent();

        String fileName = "encryptedFile" + countFile + ".txt";
        Path encryptFile = parentDirectory.resolve(fileName);

        writeFile(encryptFile.toFile(), chars);

    }

    public void creatNameDecryptedFile(File file, char[] chars) {


        Path parentDirectory = file.toPath().getParent();

        String fileName = "decryptedFile" + countFile + ".txt";

        Path decryptFile = parentDirectory.resolve(fileName);

        writeFile(decryptFile.toFile(), chars);

    }

    public char[] readFile(File file) {

        StringBuilder builder = new StringBuilder();


        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            while (buffer.ready()) {
                String line = buffer.readLine().toLowerCase();
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Файл не существует или неправильно указан путь к файлу");
            throw new RuntimeException(e);
        }


        return builder.toString().toCharArray();
    }

    public void writeFile(File file, char[] chars){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (char aChar : chars) {
                bufferedWriter.write(Character.toString(aChar));
            }
        } catch (Exception e) {
            System.out.println("Неправильно задана директория!");
            throw new RuntimeException(e);
        }
    }


}
