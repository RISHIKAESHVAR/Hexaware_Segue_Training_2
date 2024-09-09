package hexaware1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Priority {

    public static void main(String[] args) {
        int[] array = {4, 6, 17, 8, 9, 3, 24, 6, 7, 2, 23, 14, 5};

        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : array) {
            queue.add(num);
        }

        System.out.println("Enter num");

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        System.out.println("kth min ele: " + queue.poll());
    }
}

