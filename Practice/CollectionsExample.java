import java.util.List;
import java.util.ArrayList;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        // add(element) method
        items.add(23);
        items.add(24);
        System.out.println(items);

        // add(at spefied position, element) method
        items.add(1, 30);

        // set(position, element) method
        items.set(0, 1);
        System.out.println(items);

        // get(position) method
        System.out.println(items.get(0));
        List<Integer> items2 = new ArrayList<>();
        items2.add(1);
        items2.add(2);

        // addAll() method 
        items2.addAll(items);
        System.out.println(items2);


        // remove(postion) method
        items2.remove(0);
        System.out.println(items2);


    }
}
