package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _Stream2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,77,63,60,44,33,32};
        System.out.println("min value = " + Arrays.stream(numbers).min().getAsInt() );
        IntStream.of(numbers).max().ifPresent(maxValue -> System.out.println("max value = " + maxValue));

    }
}
