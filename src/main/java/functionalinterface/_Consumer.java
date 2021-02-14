package functionalinterface;

import java.util.function.Consumer;

//Represents an operation that accepts a single input argument and returns no result.
public class _Consumer {
    public static void main(String[] args) {
        final Customer mostafa_sroor = new Customer("Mostafa Sroor", "70259437");
        //Normal Java Function
        greetingCutomer(mostafa_sroor);

        //Consumer Functional Interface
        greetingCustomerConsumer.accept(mostafa_sroor);
    }

    static void greetingCutomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + " thanks for registering with phone number " + customer.getPhone());
    }

    static Consumer<Customer> greetingCustomerConsumer =
            (customer) -> System.out.println("Hello " + customer.getName() + " thanks for registering with phone number " + customer.getPhone());

    static class Customer {
        private String name;
        private String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}
