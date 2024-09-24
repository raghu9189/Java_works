package Java.PracticeSnippets;
class StaticClass{
    int rollNo;
    String name;
    static String collegeName = "NSV";
    StaticClass(int r, String n){
        rollNo = r;
        name = n;
    }
    void display(){
        System.out.println("Roll = " + rollNo + "name = " + name + "college" + collegeName );
    }
    static void run(){
        System.out.println("Static method");
    }
}
public class StaticKeyword {
    public static void main(String[] args) {
        StaticClass.run();
        StaticClass S = new StaticClass(10, "Raghu");
        S.display();
    }
}
