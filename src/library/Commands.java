package library;

public interface Commands {
    String EXIT = "0";
    String ADD_BOOK = "1";
    String PRINT_ALL_BOOKS = "2";
    String SEARCH_BOOK_BY_TITLE = "3";
    String PRINT_MOST_EXPENSIVE_BOOK = "4";
    String DELETE_BOOK_BY_INDEX = "5";
    String SEARCH_BOOK_BY_PRICE_RANGE = "6";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " for the EXIT");
        System.out.println("Please input " + ADD_BOOK + " to ADD A BOOK");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " to PRINT ALL THE BOOKS");
        System.out.println("Please input " + SEARCH_BOOK_BY_TITLE + " to SEARCH THE BOOK BY TITLE");
        System.out.println("Please input " + PRINT_MOST_EXPENSIVE_BOOK + " to PRINT THE MOST EXPENSIVE BOOK");
        System.out.println("Please input " + DELETE_BOOK_BY_INDEX + " to DELETE A BOOK BY INDEX");
        System.out.println("Please input " + SEARCH_BOOK_BY_PRICE_RANGE + " to SEARCH A BOOK BY PRICE RANGE");
    }
}
