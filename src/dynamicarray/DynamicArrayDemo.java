package dynamicarray;

import java.util.Scanner;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray o = new DynamicArray();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the numbers of elements you want to add: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the elements you want to add: ");
        for (int i = 0; i < n; i++) {
            o.add(Integer.parseInt(sc.nextLine()));
        }

        o.print();
        System.out.println();
        System.out.println(o.getByIndex(0));
        System.out.println(o.getByIndex(7));
        System.out.println(o.getByIndex(21));
    }
}
