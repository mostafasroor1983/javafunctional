package functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
      int i = incrementByOne(0);
        System.out.println(i);

      int j = incrementByOneFunction.apply(0);
        System.out.println(i);

    }

    // increment method using functional interface
    static Function<Integer,Integer> incrementByOneFunction = j ->  j +1;

    static int incrementByOne(int i){
          return  i + 1;
    }
}
