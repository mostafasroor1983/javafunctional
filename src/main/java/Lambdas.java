import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {
        Function<String, String> upperCase = (name) -> {
            if (name.isBlank())
                throw new IllegalArgumentException("name can't be null");
            else
               return name.toUpperCase();
        };

        System.out.println(upperCase.apply("Mostafa"));
        //System.out.println(upperCase.apply(null));

    }
}
