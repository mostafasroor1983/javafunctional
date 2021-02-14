package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _Stream3 {
    private static List<Product> productsList = new ArrayList<Product>();

    public static void main(String[] args) {

        // Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        // With Java 8 Stream API'S
        withStreamAPI();
    }

    private static void withStreamAPI() {
        // filtering data of list
        List<Float> productPriceList = productsList.stream()
                .filter((product) -> product.getPrice() > 25000)
                .map((product) -> product.getPrice())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        // displaying data
        productPriceList.forEach((price) -> System.out.println(price));

        // Using Collectors's method to sum the prices.
        double sum = productsList.stream()
                .collect(Collectors.summingDouble(product -> product.getPrice()));
        System.out.println("sum = " + sum);

        // get minimum value
        productsList.stream()
                .min((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1)
                .ifPresent(product -> System.out.println("min = " + product.getPrice()));

        // Converting Product List into a Map
        Map<Integer, String> productPriceMap = productsList.stream()
                .collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
        System.out.println(productPriceMap);


    }
}