package Java.PracticeSnippets;
abstract class PersonA{
    public void name() {
        System.out.println("Name : Person A");
    }
    abstract void getName();
    abstract void getSalary();
}
class PersonB extends PersonA{
    void getName(){
        System.out.println("Name : Person B ");
    }

    @Override
    void getSalary() {
        System.out.println("Salary : 100,000");
    }
}
abstract class Mobile{
    void camera(){
        System.out.println("Camera..");
    }
    abstract void call();
    abstract void music();
    abstract void flash();
}
abstract class iPhone extends Mobile{
    void call(){
        System.out.println("Calling..");
    }
    void music(){
        System.out.println("Music..");
    }
    void flash(){
        System.out.println("Flash..");
    }
    abstract void bioLock();
}
class samsung extends iPhone{

    @Override
    void bioLock() { 
        System.out.println("Lock..");
    }
}
public class AbstractClass {
    public static void main(String[] args) {
        samsung s = new samsung();
        s.flash();
        s.bioLock();
    }
}
