package util;

import constants.AppConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandlerUtil {


    public void createEncryptedFile(String sourceName, char[] content, boolean isEncrypt) {

        Path parentDir = Path.of(sourceName).toAbsolutePath().getParent();
        String fileName = (isEncrypt)
                ? AppConstants.FILE_NAME_ENCRYPTED
                : AppConstants.FILE_NAME_DECRYPTED;

        Path targetFile = parentDir.resolve(fileName);

        writeFile(targetFile.toFile(), content);
        System.out.println(AppConstants.PROCESS_COMPLETE + targetFile);
    }

    public void createBruteForceFile(String sourceName, char[] content, int key) {

        Path parentDir = Path.of(sourceName).toAbsolutePath().getParent();
        Path bruteDir = parentDir.resolve(AppConstants.DIRECTORY_BRUTEFORCE);

        try {
            Files.createDirectories(bruteDir);

            String fileName = AppConstants.FILE_NAME_BRUTFORSE + key + AppConstants.EXTENSION;

            Path target = bruteDir.resolve(fileName);
            writeFile(target.toFile(), content);

        } catch (IOException e) {
            throw new RuntimeException(AppConstants.ERROR_CREAT_FILE_BRUTFORSE + key, e);
        }
    }

    public static char[] readFile(String fileName) {

        StringBuilder builder = new StringBuilder();


        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            while (buffer.ready()) {
                String line = buffer.readLine().toLowerCase();
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println(AppConstants.ERROR_FILE_NOT_FOUND + ": " + fileName);
            throw new RuntimeException(e);
        }

        return builder.toString().toCharArray();
    }

    public void writeFile(File file, char[] content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (char aChar : content) {
                bufferedWriter.write(Character.toString(aChar));
            }
        } catch (IOException e) {
            System.err.println(AppConstants.ERROR_INVALID_OUTPUT_PATH + ": " + file.getPath());
            throw new RuntimeException(e);
        }
    }
}
