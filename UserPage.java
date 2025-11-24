import java.util.Scanner;

public class UserPage {

    Bookstore store = new Bookstore();

    public void menu(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n===== USER DASHBOARD =====");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Buy Book");
            System.out.println("4. Logout");

            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) viewBooks();
            else if (ch == 2) searchBook();
            else if (ch == 3) buyBook();
            else break;
        }
    }

    private void viewBooks(){
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

    private void buyBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID to Buy: ");
        String id = sc.nextLine();
        store.buyBook(id);
    }
}
