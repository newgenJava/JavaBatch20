package newgen;
public class MaxValueFinder {
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 5};
        System.out.println("Maximum value: " + findMax(numbers));
    }
}
