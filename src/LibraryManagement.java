import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý thư viện");
            System.out.println("1. Thêm sách");
            System.out.println("2. Mượn sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Tìm kiếm sách theo tên");
            System.out.println("5. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    searchBookByName(scanner);
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    // Thêm sách
    static void addBook(Scanner scanner) {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Nhập mã sách: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String title = scanner.nextLine();
        System.out.print("Nhập tác giả: ");
        String author = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Book newBook = new Book(id, title, author, quantity);
        books.add(newBook);
        System.out.println("Sách đã được thêm!");
    }

    // Mượn sách
    static void borrowBook(Scanner scanner) {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Nhập mã sách để mượn: ");
        String bookId = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.id.equals(bookId)) {
                if (book.quantity > 0) {
                    book.quantity--;
                    System.out.println("Mượn sách thành công!");
                    found = true;
                    break;
                } else {
                    System.out.println("Sách đã hết!");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách!");
        }
    }

    // Hiển thị sách
    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Thư viện hiện không có sách.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    static void searchBookByName(Scanner scanner) {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Nhập tên sách để tìm kiếm: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách!");
        }
    }
}