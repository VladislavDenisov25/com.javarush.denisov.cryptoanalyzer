import java.io.*;
import java.nio.file.Path;

class FileHandler {

    private static int countFile;

    public FileHandler() {
        countFile++;
    }

    public void encryptedFile(File file, char[] chars) {


        Path parentDirectori = file.toPath().getParent();

        String fileName = "encryptedFile" + countFile + ".txt";
        Path encryptFile = parentDirectori.resolve(fileName);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(encryptFile.toFile()))) {
            for (int i = 0; i < chars.length; i++) {
                bufferedWriter.write(Character.toString(chars[i]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void decryptedFile(File file, char[] chars) {


        Path parentDirectori = file.toPath().getParent();

        String fileName = "decryptedFile" + countFile + ".txt";

        Path decryptFile = parentDirectori.resolve(fileName);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(decryptFile.toFile()))) {
            for (int i = 0; i < chars.length; i++) {
                bufferedWriter.write(Character.toString(chars[i]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
