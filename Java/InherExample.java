package Java;
//Method Overriding Example
class Bank{
    int getRate(){
        return 0;
    }
}
class ICICI extends Bank{
    int getRate(){
        return 8;
    }
}
class AXIS extends Bank{
    int getRate(){
        return 9;
    }
}
//Multilevel inheritance

class ParentClass{
    void display(){
        System.out.println("A");
    }
}
class ChildClass extends ParentClass{
    void display(){
        System.out.println("B");
    }
}
class LowerChildClass extends ChildClass{
    void display(){
        System.out.println("C");
    }
}

//Hierarchical inheritance

class A{
    int x=10;
    void show(){
        System.out.println(x);
    }
}
class B extends A{
    int b = 20;
    void show(){
        System.out.println(b);
    }
}
class C extends A{
    int c = 30;
    void show(){
        System.out.println(c);
    }
}

class Employee{
    float salary = 4000f;
}
public class InherExample extends Employee {
    int bonus = 10000;
    public static void main(String[] args) {
        /*
        ICICI i = new ICICI();
        AXIS a = new AXIS();
        System.out.println(i.getRate());
        System.out.println(a.getRate());
        LowerChildClass l = new LowerChildClass();
        l.display();
        C obj = new C();
        obj.show();
        */
        InherExample p = new InherExample();
        System.out.println("Emplyee salary = " + p.salary);
        System.out.println("Emplyee salary = " + p.bonus);
    }
}
