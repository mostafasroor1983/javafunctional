package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class _Consumer {
    public static void main(String[] args) {
        final Customer mostafa_sroor = new Customer("Mostafa Sroor", "70259437");
        //Normal Java Function
        greetingCustomer(mostafa_sroor);

        //Consumer Functional Interface
        greetingCustomerConsumer.accept(mostafa_sroor);

        //BiConsumer Functional Interface
        greetingCustomerConsumerV2.accept(mostafa_sroor, false);
        greetingCustomerConsumerV2.accept(mostafa_sroor, true);
    }

    static void greetingCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + " thanks for registering phone number " + customer.getPhone());
    }

    //Represents an operation that accepts a single input argument and returns no result.
    static Consumer<Customer> greetingCustomerConsumer =
            (customer) -> System.out.println("Hello " + customer.getName() + " thanks for registering phone number " + customer.getPhone());

    //Represents an operation that accepts two input arguments and returns no result.
    static BiConsumer<Customer, Boolean> greetingCustomerConsumerV2 =
            (customer, showPhoneNumber) -> {
                System.out.println("Hello " + customer.getName() +
                        " thanks for registering phone number " +
                        (showPhoneNumber ? customer.getPhone() : "********"));
            };

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
