package service;

public class Alphabet {

    private final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '"', ':', '-', '!', '?', ' '};


    public char[] getAlphabet(){
        return ALPHABET;
    }


    public int getAlphabetLength(){
        return ALPHABET.length;
    }
}
