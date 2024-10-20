class Student<T>{
    T name;
    Student(T name){this.name = name;};
    public T getName(){
        return this.name;
    }

    public T getExtraname(){
        return  this.name;
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Student<String> student = new Student<String>("Raghu");
        System.out.println(student.getName());
    }
}
