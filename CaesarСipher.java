import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CaesarСipher {

    public static final char[] CHARS_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};



    public char[] encryption(File file, int key) {


        int bias = Math.abs(key % CHARS_ALPHABET.length);
        StringBuilder bulder = new StringBuilder();


        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            while (buffer.ready()) {
                String line = buffer.readLine().toLowerCase();
                bulder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Файл не существует или неправильно указан путь к файлу");
            throw new RuntimeException(e);
        }


        char[] chars = bulder.toString().toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            char nextChar = chars[i];
            int number = indexSearch(nextChar);

            if (number != -1) {
                int index = number + bias;
                if (index > CHARS_ALPHABET.length - 1) {
                    index = Math.abs(CHARS_ALPHABET.length - index);
                }
                nextChar = CHARS_ALPHABET[index];
            }
            result[i] = nextChar;
        }

        return result;
    }


   public char[] decryption(File file, int key){

       int bias = Math.abs(key % CHARS_ALPHABET.length);

       StringBuilder bulder = new StringBuilder();


       try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
           while (buffer.ready()) {
               String line = buffer.readLine().toLowerCase();
               bulder.append(line).append("\n");
           }
       } catch (IOException e) {
           System.out.println("Файл не существует или неправильно указан путь к файлу");
           throw new RuntimeException(e);
       }


       char[] chars = bulder.toString().toCharArray();
       char[] result = new char[chars.length];

       for (int i = 0; i < chars.length; i++) {
           char nextChar = chars[i];
           int number = indexSearch(nextChar);

           if (number != -1) {
               int index = number - bias;
               if (index > CHARS_ALPHABET.length - 1) {
                   index = Math.abs(CHARS_ALPHABET.length - index);
               } else if (index < 0){
                   index = Math.abs(CHARS_ALPHABET.length + index);
               }
               nextChar = CHARS_ALPHABET[index];
           }
           result[i] = nextChar;
       }

       return result;
   }



    public int indexSearch(char chr) {

        for (int i = 0; i < CHARS_ALPHABET.length; i++) {
            char chars = CHARS_ALPHABET[i];
            if (chars == chr) {
                return i;
            }
        }
        return -1;
    }


}
