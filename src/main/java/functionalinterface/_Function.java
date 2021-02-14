package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes 1 argument and produces 1 result
        int i = incrementByOne(0);
        System.out.println(i);

        int j = incrementByOneFunction.apply(0);
        System.out.println(i);

        final Function<Integer, Integer> channingFunction = incrementByOneFunction.andThen(multiplyByOneFunction);
        int k = channingFunction.apply(1);
        System.out.println(k);

        //Bu-iFunction takes 2 argument and produces 1 result
        int b = incrementByOnAndMultiplyByNumFunction.apply(4, 100);
        System.out.println(b);
    }

    // multiply method using functional interface
    static Function<Integer, Integer> multiplyByOneFunction = k -> k * 10;

    // increment method using functional interface
    static Function<Integer, Integer> incrementByOneFunction = j -> j + 1;

    static BiFunction<Integer, Integer, Integer> incrementByOnAndMultiplyByNumFunction =
            (i, j) -> (i + 1) * j;

    static int incrementByOne(int i) {
        return i + 1;
    }
}
