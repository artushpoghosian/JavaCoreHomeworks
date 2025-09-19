public class ArrayHomework {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 11, 12, 21, 6, 25, 33, 6, 49};
        int n = 6;

        //Task 1
        System.out.println("TASK 1");
        int countOfn = 0;
        for (int number : numbers) {
            if (number == n) countOfn++;
        }
        System.out.println("There are " + countOfn + " element(s) of `" + n + "` in the array.");

        //Task 2
        System.out.println("\nTASK 2");
        System.out.print("The array in original order: ");
        for (int number : numbers)
            System.out.print(number + " ");

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
        System.out.println();
        System.out.print("The array in reverse  order: ");
        for (int number : numbers)
            System.out.print(number + " ");

        //Task 3
        System.out.println("\n\nTASK 3");
        int countOfRepeatingNumbers = 0;
        int[] countedDuplicates = new int[numbers.length];
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    boolean alreadyCounted = false;
                    for (int k = 0; k < index; k++) {
                        if (numbers[i] == countedDuplicates[k]) {
                            alreadyCounted = true;
                            break;
                        }
                    }
                    if (alreadyCounted == false) {
                        countedDuplicates[index] = numbers[i];
                        index++;
                        countOfRepeatingNumbers++;
                    }
                }
            }
        }
        System.out.println("There are " + countOfRepeatingNumbers + " duplicate(s) in the array.");

        //Task 4
        System.out.println("\nTASK 4");
        char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        char[] vowels = {'ա', 'ե', 'է', 'ը', 'ի', 'ո', 'օ'};
        int countOfVowels = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (chars[i] == vowels[j]) {
                    countOfVowels++;
                    break;
                }
            }
        }
        System.out.print("There are " + countOfVowels + " vowels in total.");
    }
}