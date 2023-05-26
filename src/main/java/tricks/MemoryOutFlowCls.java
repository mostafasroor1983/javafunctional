package tricks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryOutFlowCls {
    public static void main(String[] args) {
        long size1 = Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        generateEmployees(18000000);
        //System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000F);
        long end = System.currentTimeMillis();
        long size2 = Runtime.getRuntime().freeMemory();
        System.out.println((end - start) / 1000F);
        System.out.println((size2 - size1) / 1000F);
        //System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000F);
    }

    public static List<Employee> generateEmployees(int count) {

        IntStream rangeEmployees = IntStream.range(1, count);
        //rangeEmployees.map(i -> i * 2).forEach(System.out::println);
        return rangeEmployees.boxed()
                .map(i -> createEmployee(i))
                //.peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static Employee createEmployee(int index) {
        return new Employee("name" + index, index, index);
    }

    static class Employee {
        String name;
        Integer yearsOfExperience;
        Integer age;

        public Employee(String name, Integer yearsOfExperience, Integer age) {
            this.name = name;
            this.yearsOfExperience = yearsOfExperience;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", yearsOfExperience=" + yearsOfExperience +
                    ", age=" + age +
                    '}';
        }
    }
}
