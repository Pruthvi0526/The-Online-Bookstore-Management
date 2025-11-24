import java.io.*;
import java.util.*;

public class Bookstore {

    private static final String BOOK_FILE = "books.txt";

    public Bookstore() {
        try {
            File file = new File(BOOK_FILE);
            if (!file.exists()) file.createNewFile();
        } catch (Exception ignored) {}
    }

    public void addBook(Book book){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE, true))){
            bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice());
            bw.newLine();
            System.out.println("Book added successfully!");
        } catch(Exception e){
            System.out.println("Error adding book");
        }
    }

    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                list.add(new Book(data[0], data[1], data[2], Double.parseDouble(data[3])));
            }
        } catch(Exception ignored){}
        return list;
    }

    public Book searchBook(String id){
        return getAllBooks().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void buyBook(String id){
        Book book = searchBook(id);
        if (book != null){
            System.out.println("You purchased: " + book.getTitle() + " | Price: ₹" + book.getPrice());
        } else {
            System.out.println("Book not found!");
        }
    }
}
