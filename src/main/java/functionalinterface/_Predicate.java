package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        //Normal Method
        System.out.println(isPhoneNumberValid("70259437"));

        //Predicate Functional Interface
        System.out.println(isValidPhoneNumberPredicate.test("71259437"));

        System.out.println(isValidPhoneNumberPredicate.and(containsPhoneNumber3Predicate).test("70259437"));

        System.out.println(isValidPhoneNumberPredicate.and(containsPhoneNumber3Predicate).test("71259477"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("70") && phoneNumber.length() == 8;
    }

    //Represents a predicate (boolean-valued function) of one argument.
    static Predicate<String> isValidPhoneNumberPredicate = (phoneNumber) -> phoneNumber.startsWith("70") && phoneNumber.length() == 8;

    static Predicate<String> containsPhoneNumber3Predicate = (phoneNumber) -> phoneNumber.contains("3");

}
