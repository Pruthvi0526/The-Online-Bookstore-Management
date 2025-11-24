import java.io.*;
import java.util.*;

public class AuthSystem {

    private static final String USER_FILE = "users.txt";

    public AuthSystem() {
        File file = new File(USER_FILE);
        try {
            if (!file.exists()) file.createNewFile();
        } catch (Exception e) {
            System.out.println("Error while creating user file.");
        }
    }

    public boolean register(String username, String password, String role) {
        if (userExists(username)) return false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(username + "," + password + "," + role);
            bw.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new User(data[0], data[2]); // username, role
                }
            }

        } catch (Exception ignored) {}

        return null;
    }

    private boolean userExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username)) return true;
            }
        } catch (Exception ignored) {}
        return false;
    }
}
