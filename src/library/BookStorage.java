package library;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].equals(book)) {
                books[i].setQuantity(books[i].getQuantity() + book.getQuantity());
                return;
            }
        }
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] temp = new Book[size + 10];
        System.arraycopy(books, 0, temp, 0, size);
        books = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void search(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(books[i]);
            }
        }
    }

    public Book getBookByMaxPrice() {
        double price = 0;
        int maxIndex = -1;
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() > price) {
                price = books[i].getPrice();
                maxIndex = i;
            }
        }
        return books[maxIndex];
    }

    public void deleteBookByIndex(int index) {
        if ((index - 1) < 0 || (index - 1) >= size) {
            System.err.println("Invalid index");
            return;
        }
        if (books[index - 1].getQuantity() > 1) {
            books[index - 1].setQuantity(books[index - 1].getQuantity() - 1);
            return;
        }
        for (int i = index - 1; i < size - 1; i++) {
                books[i] = books[i + 1];
        }
        size--;
    }

    public void searchBookByPriceRange(double minPrice, double maxPrice) {
        if (isEmpty()) {
            System.out.println("No Books in The Library");
            return;
        }
        if (minPrice > maxPrice) {
            System.err.println("Invalid input. Please try again.");
            return;
        }
        boolean bookFoundInTheRange = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= minPrice && books[i].getPrice() <= maxPrice) {
                System.out.println(books[i]);
                bookFoundInTheRange = true;
            }
        }
        if (!bookFoundInTheRange) {
            System.out.println("No Book found in this Price Range");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
