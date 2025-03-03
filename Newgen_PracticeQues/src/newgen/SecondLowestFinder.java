package newgen;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLowestFinder {
    public static int findSecondLowest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        Arrays.sort(arr); // Sort the array in ascending order
        
        int firstLowest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > firstLowest) {
                return arr[i]; // Return the second distinct lowest value
            }
        }
        
        throw new IllegalArgumentException("No second distinct lowest value found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println("Array must contain at least two elements.");
            scanner.close();
            return;
        }

        int[] numbers = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        try {
            int secondLowest = findSecondLowest(numbers);
            System.out.println("Second lowest value: " + secondLowest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}