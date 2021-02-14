package combinator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Mostafa", "70259437", "mostafa.sroor.1983@gmail.com",
                LocalDate.of(1983, 3, 14));

        CustomerValidatorService service = new CustomerValidatorService();
        System.out.println("service.isValid() = " + service.isValid(c1));

        // if valid we can store cutomer in db

        //Using Combinator pattern

        CustomerRegisterationValidator.ValidationResult result = CustomerRegisterationValidator.isAdult()
                .and(CustomerRegisterationValidator.isEmailValid())
                .and(CustomerRegisterationValidator.isPhoneValid())
                .apply(c1);
        System.out.println(result);

        if(result != CustomerRegisterationValidator.ValidationResult.SUCCESS){
         throw new IllegalStateException("Data Not Valid ...");
        }
    }
}
