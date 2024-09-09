package hexaware1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8);


        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {

        Set<Integer> set = new HashSet<>(list);
        

        return new ArrayList<>(set);
    }
}