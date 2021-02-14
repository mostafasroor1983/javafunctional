package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        //Normal Method
        System.out.println(getDBConnectionUrl());

        //Supplier interface
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    //Represents a supplier of results.
    // return any kind of value you want
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";
}
