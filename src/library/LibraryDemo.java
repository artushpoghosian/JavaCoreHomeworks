package library;

import java.util.Scanner;

public class LibraryDemo implements Commands{

    private static Scanner sc = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {
        boolean isRunning = true;

        while(isRunning){
            Commands.printCommands();
            String command = sc.nextLine();

            switch (command){
                case EXIT:
                    isRunning = false;
                    System.out.println("The program has been terminated.");
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case SEARCH_BOOK_BY_TITLE:
                    System.out.println("Enter a keyword:");
                    String keyword = sc.nextLine();
                    bookStorage.search(keyword);
                case PRINT_MOST_EXPENSIVE_BOOK:
                    System.out.println(bookStorage.getBookByMaxPrice());
                    break;
                case DELETE_BOOK_BY_INDEX:
                    System.out.println("Enter an index:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    bookStorage.deleteBookByIndex(index);
                    break;
                case SEARCH_BOOK_BY_PRICE_RANGE:
                    System.out.println("Enter the minimum price:");
                    double minimumPrice = sc.nextInt();
                    System.out.println("Enter the maximum price:");
                    double maximumPrice = sc.nextInt();
                    bookStorage.searchBookByPriceRange(minimumPrice, maximumPrice);
                    sc.nextLine();
                    break;
                default:
                    System.err.println("Invalid input. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("Enter the book's title:");
        String bookTitle = sc.nextLine();
        System.out.println("Enter the author's name:");
        String authorName = sc.nextLine();
        System.out.println("Enter the price of the book:");
        double price = Double.parseDouble(sc.nextLine());
        Book book = new Book(bookTitle, authorName, price);
        bookStorage.add(book);
        System.out.println("The book was added successfully");
    }
}