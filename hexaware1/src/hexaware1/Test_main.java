package hexaware1;

import java.util.*;
import java.util.stream.Collectors;

public class Test_main {
    public static void main(String[] args) {
        List<Person> p = new ArrayList<>();
        p.add(new Person("Rishikaeshvar ", 22, "Theni"));
        p.add(new Person("Nivetha", 21, "Kumbakonam"));
        p.add(new Person("Nandha", 28, "Theni"));
        p.add(new Person("Jagadesh", 34, "Banglore"));
        p.add(new Person("Mani", 39, "Hosur"));
        
        System.out.println(" Solution for Task1");
        System.out.println("------------------------------------");
        
        // Task 1: Print all names
        p.stream()
            .forEach(person -> System.out.println(person.getName()));
        
        System.out.println(" Solution for Task2");
        System.out.println("------------------------------------");

        // Task 2: Print names of persons older than 25
        p.stream()
            .filter(person -> person.getAge() > 25)
            .forEach(person -> System.out.println(person.getName()));
        
        System.out.println(" Solution for Task3");
        System.out.println("------------------------------------");

        // Task 3: List names of persons in "Theni"
        List<Person> Theni_city = p.stream()
            .filter(person -> "Theni".equals(person.getCity()))
            .collect(Collectors.toList());
        Theni_city.forEach(person -> System.out.println(person.getName()));
        
        System.out.println(" Solution for Task4");
        System.out.println("------------------------------------");

        // Task 4: List ages of persons above 30
        List<Person> agesAbove30 = p.stream()
            .filter(person -> person.getAge() > 30)
            .collect(Collectors.toList());
        agesAbove30.forEach(person -> System.out.println(person.getAge()));
        
        System.out.println(" Solution for Task5");
        System.out.println("------------------------------------");

        // Task 5: Print persons sorted by age
        p.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .forEach(person -> System.out.println(person));
        
        System.out.println(" Solution for Task6");
        System.out.println("------------------------------------");

        // Task 6: Count the number of persons in each city
        Map<String, Long> cityCount = p.stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        cityCount.forEach((city, count) -> {
            System.out.println("City: " + city + " -> Persons: " + count);
        });
        
        System.out.println(" Solution for Task7");
        System.out.println("------------------------------------");

        // Task 7: Compute average age
        double avg_age = p.stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0);
        System.out.println("Average Age: " + avg_age);
        
        System.out.println(" Solution for Task8");
        System.out.println("------------------------------------");

        // Task 8: Find maximum and minimum age
        int max_age = p.stream()
            .mapToInt(Person::getAge)
            .max()
            .orElseThrow();
        int min_age = p.stream()
            .mapToInt(Person::getAge)
            .min()
            .orElseThrow();
        System.out.println("Max Age: " + max_age);
        System.out.println("Min Age: " + min_age);
        
        System.out.println(" Solution for Task9");
        System.out.println("------------------------------------");

        // Task 9: Group persons by city
        Map<String, List<Person>> pbc = p.stream()
            .collect(Collectors.groupingBy(Person::getCity));
        pbc.forEach((city, personsList) -> {
            System.out.println("City: " + city);
            personsList.forEach(person -> System.out.println(person));
        });
        
        System.out.println(" Solution for Task10");
        System.out.println("------------------------------------");
        
        // Task 10: List unique cities
        List<String> uc = p.stream()
            .collect(Collectors.mapping(Person::getCity, Collectors.toSet()))
            .stream()
            .toList();
        System.out.println(uc);
        
        System.out.println(" Solution for Task11");
        System.out.println("------------------------------------");

        // Task 11: Concatenate all names into a single string separated by commas
        String an = p.stream()
            .collect(Collectors.mapping(Person::getName, Collectors.joining(", ")));
        System.out.println(an);
    }
}
