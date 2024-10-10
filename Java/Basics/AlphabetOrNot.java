package Java.Basics;

public class AlphabetOrNot {
    public static void main(String[] args) {
        char ch = 'L';
        if(((int)ch <= 122 && (int)ch >= 97) || ((int)ch <= 90 && (int)ch >= 65))
        System.out.println("Alphabet");
    }
}
