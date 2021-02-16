package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _Stream4 {
    private static List<Product> productsList = new ArrayList<Product>();

    public static void main(String[] args) {
        //Stream of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        collection.stream().collect(Collectors.toList()).forEach(System.out::println);

        //Stream of Array
        Stream.of("a", "b", "c").collect(Collectors.toList()).forEach(System.out::println);

        String[] arr = new String[]{"a", "b", "c"};
        Arrays.stream(arr, 1, 3).collect(Collectors.toList()).forEach(System.out::println);

        // iterate for loop
        Stream.iterate(40, n -> n + 2).limit(5).collect(Collectors.toList()).forEach(System.out::println);

        //Stream of Primitives
        IntStream.range(1, 3).findFirst().ifPresent(value -> System.out.println(value));

        //Referencing a Stream
        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        stream.findAny().ifPresent(value -> System.out.println(value));
    }
}