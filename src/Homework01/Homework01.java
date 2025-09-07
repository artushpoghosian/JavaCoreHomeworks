package Homework01;

public class Homework01 {
    public static void main(String[] args) {

        //task 1
        System.out.println("TASK 1");
        int x = 10;
        int y = 13;
        if (x > y)
            System.out.println("The number " + x + " is larger than " + y);
        else
            System.out.println("The number " + y + " is larger than " + x);

        System.out.println();

        //task2
        System.out.println("TASK 2");
        for (int i = 1; i <= 5; i++)
            System.out.print(i + " ");

        System.out.println("\n");

        //task3
        System.out.println("TASK 3");
        int a = 5;
        int b = 7;
        System.out.println("The SUM of the numbers " + a + " and " + b + " is " + (a + b));

        System.out.println("");

        //task4
        System.out.println("TASK 4");
        int n = 3;
        for (int i = 1; i < 11; i++)
            System.out.println(n + " * " + i + " = " + n * i);
    }
}