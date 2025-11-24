import java.util.Scanner;

public class LoginPage {

    AuthSystem auth = new AuthSystem();

    public void start(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("===== ONLINE BOOKSTORE =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1){
                login();
            } else if (ch == 2){
                register();
            } else {
                System.out.println("Thank you!");
                break;
            }
        }
    }

    private void login(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        User loggedUser = auth.login(user, pass);

        if (loggedUser != null){
            System.out.println("Login successful!");

            if (loggedUser.getRole().equals("admin")){
                new AdminPage().menu();
            } else {
                new UserPage().menu();
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private void register(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose Username: ");
        String user = sc.nextLine();
        System.out.print("Choose Password: ");
        String pass = sc.nextLine();

        System.out.print("Role (admin/user): ");
        String role = sc.nextLine();

        if (auth.register(user, pass, role)){
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists!");
        }
    }
}
