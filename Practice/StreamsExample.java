import java.util.List;
import java.util.stream.Collectors;

enum Gender {
    FEMALE, MALE
}

class Person {
    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    @Override
    public String toString() {

        return name + " " + age + " " + gender;
    }

}


public class StreamsExample {
    public static void main(String[] args) {

        List<Person> people = getPeople();

        // List<Person> females = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        List<Person> females = people.stream().filter(person -> person.getAge() == 25).collect(Collectors.toList());

        females.forEach(System.out::println);

        
    }
    private static List<Person> getPeople(){
        return List.of(
            new Person("Raghu", 25, Gender.MALE),
            new Person("Ramya", 23, Gender.FEMALE),
            new Person("Hari Chandana", 45, Gender.FEMALE),
            new Person("Mahesh", 21, Gender.MALE)
            );
    }
}
