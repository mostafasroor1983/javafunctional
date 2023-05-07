package howtodojava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://howtodoinjava.com/java8/java-streams-by-examples/
//A Stream in Java 8 can be defined as a sequence of elements from a source.
// Streams supports aggregate operations on the elements.
// The source of elements here refers to a Collection or Array that provides data to the Stream.
public class Stream1 {

    //Stream keeps the ordering of the elements the same as the ordering in the source.
    // The aggregate operations are operations that allow us to express common manipulations on
    // stream elements quickly and clearly.
    public static void main(String[] args) {

        //creating a stream of a fixed number of integers.
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p -> System.out.println(p));

        //creating a stream from the array. The elements in the stream are taken from the array.
        Stream<Integer> stream2 = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream2.forEach(p -> System.out.println(p));

        //creating a stream from the List. The elements in the stream are taken from the List.
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream3 = list.stream();
        stream3.forEach(p -> System.out.println(p));


        //we are creating a stream from generated elements.
        // This will produce a stream of 20 random numbers. We have restricted the elements count using limit() function.
        Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
        randomNumbers.limit(20).forEach(System.out::println);

        //collecting all even numbers into a List
        List<Integer> list11 = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list11.add(i);
        }
        Stream<Integer> stream11 = list11.stream();
        List<Integer> evenNumbersList = stream11.filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);

        //Collect Stream elements to an Array
        List<Integer> listww = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            listww.add(i);
        }
        Stream<Integer> streamww = list.stream();
        Integer[] evenNumbersArr = streamww.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);
        ////////////////////////////////

        //4 Stream Operations
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Aana");
        memberNames.add("Lokesh");
        ////////////////////////////////


        //4.1 Intermediate Operations
        //4.1.1 Stream.filter()
        // The filter() method accepts a Predicate to filter all elements of the stream.
        // This operation is intermediate which enables us to call another stream operation (e.g. forEach()) on the result.
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);

        //4.1.2. Stream.map()
        //The map() intermediate operation converts each element in the stream into another object via the given function.
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //4.1.3. Stream.sorted()
        // The sorted() method is an intermediate operation that returns a sorted view of the stream.
        // The elements in the stream are sorted in natural order unless we pass a custom Comparator.
        memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        ////////////////////////////////
        //4.2. Terminal operations
        //Terminal operations return a result of a certain type after processing all the stream elements.
        //4.2.1. Stream.forEach()
        memberNames.forEach(System.out::println);

        //4.2.2. Stream.collect()
        //The collect() method is used to receive elements from a steam and store them in a collection.
        List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(memNamesInUppercase);


        //4.2.3. Stream.match()
        // Various matching operations can be used to check whether a given predicate matches the stream elements.
        // All of these matching operations are terminal and return a boolean result

        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        //4.2.4. Stream.count()
        //The count() is a terminal operation returning the number of elements in the stream as a long value.
        long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched);

        //4.2.5. Stream.reduce()
        //The reduce() method performs a reduction on the elements of the stream with the given function.
        // The result is an Optional holding the reduced value.
        // In the given example, we are reducing all the strings by concatenating them using a separator #.
        Optional<String> reduced = memberNames.stream()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);


        //5. Stream Short-circuit Operations
        //Though stream operations are performed on all elements inside a collection satisfying a Predicate,
        // it is often desired to break the operation whenever a matching element is encountered during iteration.

        //5.1. Stream.anyMatch()
        //The anyMatch() will return true once a condition passed as predicate satisfies.
        // Once a matching value is found, no more elements will be processed in the stream.
        boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matched);

        //5.2. Stream.findFirst()
        //The findFirst() method will return the first element from the stream and then it will not process any more elements.
        String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();

        System.out.println(firstMatchedName);

        //6. Parallelism in Java Steam

        List<Integer> listff = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            listff.add(i);
        }

        //Here creating a parallel stream
        Stream<Integer> streamff = listff.parallelStream();

        Integer[] evenNumbersArrff = streamff.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArrff);


        //https://howtodoinjava.com/java8/java8-boxed-intstream/
        //To convert a stream of primitives, we must first box the elements in their wrapper classes and then
        // collect the wrapped objects in a collection.
        // This type of stream is called boxed stream.
        //Get the collection and later convert to stream to process elements
        List<Integer> ints = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        //Stream operations directly
        Optional<Integer> max = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .max(Integer::compareTo);
        System.out.println(max.get());

    }
}
