public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        //Task 1
        System.out.println("TASK 1");
        System.out.print("The array consists of the following elements: ");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");

        //Task 2
        System.out.println("\n\nTASK 2");
        System.out.println("The first element of the array is " + numbers[0]);

        //Task 3
        System.out.println("\nTASK 3");
        System.out.println("The last element of the array is " + numbers[numbers.length - 1]);

        //Task 4
        System.out.println("\nTASK 4");
        System.out.println("The length of the array is " + numbers.length);

        //Task 5
        System.out.println("\nTASK 5");
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("The smallest number in the array is " + min);

        //Task 6
        System.out.println("\nTASK 6");
        if (numbers.length > 2) {
            {
                if (numbers.length % 2 == 0) {
                    System.out.println("Two middle elements of the array are " + numbers[(numbers.length - 1) / 2] + " and " + numbers[numbers.length / 2]);
                } else {
                    System.out.println("The middle element of the array is " + numbers[numbers.length / 2]);
                }
            }
        } else {
            System.out.println("No middle values");
        }

        //Task 7
        System.out.println("\nTASK 7");
        int countOfEvenNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i] % 2) == 0) {
                countOfEvenNumbers++;
            }
        }
        System.out.println("There are " + countOfEvenNumbers + " even numbers");

        //Task 8
        System.out.println("\nTASK 8");
        int countOfOddNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i] % 2) == 1) { //used Math.abs for counting -3 as an odd number
                countOfOddNumbers++;
            }
        }
        System.out.println("There are " + countOfOddNumbers + " odd numbers");

        //Task 9
        System.out.println("\nTASK 9");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("The sum of the numbers in the array is " + sum);

        //Task 10
        System.out.println("\nTASK 10");
        double average = (double) sum / numbers.length;
        System.out.println("The average of the numbers in the array is " + average);
    }
}