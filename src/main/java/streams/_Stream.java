package streams;

import imperative.Main;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Mostafa", Gender.MALE),
                new Person("Mona", Gender.FEMALE),
                new Person("Ahmad", Gender.MALE),
                new Person("Hasan", Gender.MALE),
                new Person("Safaa", Gender.FEMALE)
        );

        //Streams interface and methods

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Function<Person, String> personGenderFunction = person -> person.name;
        final ToIntFunction<String> stringToIntFunction = name -> name.length();
        IntConsumer println = x -> System.out.println(x);

        people.stream()
                .map(personGenderFunction)
                .mapToInt(stringToIntFunction)
                .forEach(println);

        // check if all elements match gender = FEMALE
        boolean allElementsAreFemale = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println("allElementsAreFemale = " + allElementsAreFemale);

        // check if any elements match gender = FEMALE
        boolean anyElementsIsFemale = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println("anyElementsIsFemale = " + anyElementsIsFemale);

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
        FEMALE, MALE
    }

}
