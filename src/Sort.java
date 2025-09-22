public class Sort {
    public static void main(String[] args) {

        int[] array = {15, 3, 36, 77, 21, 11, 24, 7, 1, 69, 45};

        for (int i = 0; i < array.length; i++) {
            int pivot = array[i];
            for (int j = 1 + i; j < array.length; j++) {
                if  (pivot > array[j]) {
                    int temp = pivot;
                    pivot = array[j];
                    array[j] = temp;
                }
            }
            array[i] = pivot;
        }

        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}