package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Object value1 = Optional.ofNullable(null)
                .orElseGet(()-> "default value");
        System.out.println(value1);

        Optional.ofNullable("mostafa.sroor.1983@gmail.com")
                .ifPresent((email)-> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                    System.out::println,
                    ()->{ System.out.println("No Data");}
                    );

        Supplier<NullPointerException> aNull = () -> new NullPointerException("Null");
        Object value2 = Optional.ofNullable(null)
                .orElseThrow(aNull);
        System.out.println(value2);

    }
}
