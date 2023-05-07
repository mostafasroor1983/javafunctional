package javascript;

import java.util.function.Consumer;

public class Callback {
    public static void main(String[] args) {
        Consumer<String> consumer = value -> System.out.println("Hello, " + value);
        hello("Mostafa", null, consumer);
    }

    static void hello(String firstName, String lastName, Consumer<String> consumer) {
        if (firstName != null) {
            System.out.println(firstName);
        }
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            consumer.accept(firstName);
        }
    }

}
