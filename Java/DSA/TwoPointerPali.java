package Java.DSA;
public class TwoPointerPali {
    static boolean isPali(String s){
        int start = 0;
        int end = s.length()-1;
        char[] charArr = s.toCharArray();
        while (start <= end) {
            if(charArr[start] != charArr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPali("aba"));
    }
}
