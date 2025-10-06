package dynamicarray;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public int getByIndex(int index) {
        if (index >= 0 && index <= size) {
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

    public void deleteByIndex(int index) {
        if (isValid(index)) {
            System.out.println("Index out of range");
            return;
        }
        int[] temp = new int[array.length];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        for (int i = index + 1; i < size; i++) {
            temp[i - 1] = array[i];
        }
        array = temp;
        size--;
    }

    public void set(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Index out of range");
        }
        array[index] = value;
    }

    public void add(int index, int value) {
        if (isValid(index)) {
            System.out.println("Index out of range");
            return;
        }
        ;
        int[] temp = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        temp[index] = value;
        for (int i = index; i < array.length; i++) {
            temp[i + 1] = array[i];
        }
        array = temp;
        size++;
    }

    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //checks if the index is valid
    public boolean isValid(int index) {
        return index < 0 || index > size;
    }
}