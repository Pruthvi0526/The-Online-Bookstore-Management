import java.util.Scanner;

public class AdminPage {

    Bookstore store = new Bookstore();

    public void menu(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Logout");

            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) addBook();
            else if (ch == 2) viewBooks();
            else if (ch == 3) searchBook();
            else break;
        }
    }

    private void addBook(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Book ID: ");
        String id = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        store.addBook(new Book(id, title, author, price));
    }

    private void viewBooks(){
        System.out.println("===== ALL BOOKS =====");
        for (Book b : store.getAllBooks())
            System.out.println(b);
    }

    private void searchBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();

        Book b = store.searchBook(id);
        System.out.println(b != null ? b : "Book not found!");
    }
}
