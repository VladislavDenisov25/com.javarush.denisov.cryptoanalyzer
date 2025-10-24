package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandlerUtil {

    private static int countFile = 0;


    public void creatNameEncryptedFile(String  fileName, char[] chars) {

        countFile++;
        Path parentDirectory = new File(fileName).toPath().getParent();
   //     String fileNameResult = "decryptedFile" + countFile + ".txt";
        String fileNameResult = "encryptedFile" + countFile + ".txt";
        Path encryptFile = parentDirectory.resolve(fileName);

        writeFile(encryptFile.toFile(), chars);

    }



//    public void creatNameBruteForceFile(File file, char[] chars, int i) {
//
//
//        Path parentDirectory = file.toPath().getParent();
//
//
//        Path newDirectory = parentDirectory.resolve("BruteForceFiles");
//        try {
//
//            if (!Files.exists(newDirectory)) {
//                Files.createDirectory(newDirectory);
//            }
//            String fileName = "BruteForceFile" + i + ".txt";
//
//            Path bruteForceFile = newDirectory.resolve(fileName);
//
//
//            writeFile(bruteForceFile.toFile(), chars);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static char[] readFile(String fileName) {

        StringBuilder builder = new StringBuilder();


        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(fileName)))) {
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

    public void writeFile(File file, char[] chars) {
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
