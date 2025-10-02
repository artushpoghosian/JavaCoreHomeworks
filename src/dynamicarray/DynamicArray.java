package dynamicarray;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if  (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    private void extend() {
        int[] largerArray = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            largerArray[i] = array[i];
        }
        array = largerArray;
    }

    public int getByIndex(int index) {
        if  (index >= 0 && index <= size) {
            return array[index];
        }
        return -1;
    }

    public void print() {
        System.out.print("Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}