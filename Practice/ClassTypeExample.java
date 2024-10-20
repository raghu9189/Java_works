
import java.util.ArrayList;

class Customer {
    private int id;
    private String name;
    
    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getFields() {
        return id + name;
    }

}

public class ClassTypeExample {
    public static void main(String[] args) {
        ArrayList<Customer> items = new ArrayList<>();
        items.add(new Customer(1, "Raghu"));
        for (Customer cust : items) {
            System.out.println("This is Obj >>>>> " + cust.getFields());
        }
    }
}
