package util;

import constants.AppConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandlerUtil {


    public void creatNameEncryptedFile(String fileName, char[] chars, char operation) {

        Path parentDirectory = new File(fileName).toPath().getParent();

        String fileNameResult = "";
        if (operation == '+') {
            fileNameResult = AppConstants.fileNameEncrypted;
        } else if (operation == '-') {
            fileNameResult = AppConstants.fileNameDecrypted;
        }
        Path encryptFile = parentDirectory.resolve(fileNameResult);

        writeFile(encryptFile.toFile(), chars);

    }

    public void creatNameBruteForceFile(String file, char[] chars, int i) {

        Path parentDirectory = new File(file).toPath().getParent();

        Path newDirectory = parentDirectory.resolve(AppConstants.nameCatalog);
        try {

            if (!Files.exists(newDirectory)) {
                Files.createDirectory(newDirectory);
            }
            String fileName = AppConstants.fileNameBrutforse + i + AppConstants.extension;

            Path bruteForceFile = newDirectory.resolve(fileName);

            writeFile(bruteForceFile.toFile(), chars);

        } catch (IOException e) {
            throw new RuntimeException(e);
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
            System.out.println(AppConstants.exception2);
            throw new RuntimeException(e);
        }

        return builder.toString().toCharArray();
    }

    public void writeFile(File file, char[] chars) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (char aChar : chars) {
                bufferedWriter.write(Character.toString(aChar));
            }
        } catch (Exception e) {
            System.out.println(AppConstants.exception3);
            throw new RuntimeException(e);
        }
    }
}
