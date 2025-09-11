package Homework01;

public class FigurePainter {
    public static void main(String[] args) {

        System.out.println("TASK 1");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        System.out.println();

        System.out.println("TASK 2");
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        System.out.println();

        System.out.println("TASK 3");
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        System.out.println();

        System.out.println("TASK 4");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < 4; k++) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        System.out.println();

        System.out.println("TASK 5");

        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < 4; k++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }

        System.out.println();

        /*
         * After completing Task 5, I was not fully satisfied because the program used 6 `for` loops.
         * To improve it, I consulted an AI model for guidance on a more optimized and short approach.
         * No code was copied from the AI. Only the logic was used to construct the rhombus using just 3 `for` loops.
         */
        System.out.println("Optimized version of TASK 5");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < Math.abs(4 - i); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 5 - Math.abs(4 - i); k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}