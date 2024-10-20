interface UserInterface {
    public abstract void showUser();
}

class User implements UserInterface{
    public void showUser(){
        System.out.println("Showing");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        UserInterface u1 = new User();
        u1.showUser();
    }

}
