package Java;
public class PatternProgram {
    public static void main(String[] args) {
        pattern4(6);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            // System.out.println(i);
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // *
    // **
    // ***
    // ****
    // *****

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // *****
    // *****
    // *****
    // *****
    // *****
    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; row <= col; col--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // *****
    // ****
    // ***
    // **
    // *
    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    // 1
    // 12
    // 123
    // 1234
    // 12345
    // 123456
}