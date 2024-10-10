package Java.DSA;
import java.util.HashMap;
import java.util.ArrayList;

public class HashMapWithUniqKeys {
    public static void main(String[] args) {
        HashMap<String, Integer> myDict = new HashMap<>();
        myDict.put("A", 65);
        myDict.put("B", 66);
        myDict.put("C", 67);
        System.out.println(myDict.get("A"));
        ArrayList<Integer> myArrayList = new ArrayList();
        myArrayList.addAll(myDict.values());
        System.out.println(myArrayList);
        System.err.println(myDict.values());
        System.out.println(myDict);
    }
}
