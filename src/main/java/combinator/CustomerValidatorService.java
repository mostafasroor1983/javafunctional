package combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneValid(String email){
        return email.startsWith("70");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 16 ;
    }

    public boolean isValid(Customer c){
        return isAdult(c.getDob()) && isEmailValid(c.getEmail()) && isPhoneValid(c.getPhone());
    }

}
