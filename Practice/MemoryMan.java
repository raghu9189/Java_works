import java.lang.Object;
import java.lang.Integer;

public class MemoryMan {
    public static void main(String[] args) {
        int num = 90;
        Object obj = new Object();
        Object obj1 = new Object();
        Integer num1 = null;
        // num1 = 89;
        System.out.println("Class name: " + obj.getClass());
        System.out.println("HashCode name: " + obj.hashCode());
        System.out.println("toString name: " + obj.toString());
        System.out.println("equals or not: " + obj.equals(obj1));
        try {
        System.out.println("primitive typw: " + num1.intValue());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("Class name: " + obj1.getClass());
        System.out.println("HashCode name: " + obj1.hashCode());

    }
}
