package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Mostafa",Gender.MALE),
                new Person("Mona",Gender.FEMALE),
                new Person("Ahmad",Gender.MALE),
                new Person("Hasan",Gender.MALE),
                new Person("Safaa",Gender.FEMALE)
        );

        //Imperative Approach
        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people ) {
           if(person.gender.equals(Gender.FEMALE)){
               females.add(person);
           }
        }

        for (Person person : females ) {
            System.out.println( person);
        }

        //Declarative Programming with streams and collections
        System.out.println("Declarative Approach");
        List<Person> females2 = people.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females2.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        FEMALE,MALE
    }
}
