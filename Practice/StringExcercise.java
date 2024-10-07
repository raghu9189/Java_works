public class StringExcercise {

    public static void main(String[] args) {
        String word = "ABFCACDB";
        String word2 = "ABFCACDBOPP";
        int stringLen = word.length();
        char ch = word.charAt(0);
        int compareValue = word.compareTo(word2);
        String concatvalue = word.concat(word2);
        boolean containsCheck = word.contains("AB");
        StringBuilder myString = new StringBuilder("Hello");
        System.out.println("Length: " + stringLen);
        System.out.println("Char: " + ch);
        System.out.println("Compare value: " + compareValue);
        System.out.println("Concat value: " + concatvalue);
        System.out.println("Contains check: " + containsCheck);
        System.out.println("Contains check: " + "ABCD".contains("AB"));
        System.out.println("String Builder Var: " + myString);
        myString.append(" World");
        System.out.println("String Builder Var: " + myString);
        myString.reverse();
        System.out.println(myString);

    }
}