import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Author{
    private String name;
    private String email;

    public Author(String name, String email){
        this.name = name;
        setEmail(email);
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        String EMAIL_PATTERN = 
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if(matcher.find()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid email!");
        }
    }

    @Override
    public String toString(){
        return getClass().getName() + "[name=" + name + ",email=" + email + "]";
    }
}

class Book{
    private String isbn;
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(String isbn,String name, Author author, double price){
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        setPrice(price);
    }

    public Book(String isbn, String name, Author author, double price, int qty){
        this(isbn, name, author, price);
        setQty(qty);
    }

    public String getIsbn(){
        return isbn;
    }

    public String getName(){
        return name;
    }

    public Author getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("Invalid price!");
        }
        this.price = price;
    }

    public int getQty(){
        return qty;
    }

    public void setQty(int qty){
        if(qty < 0){
            throw new IllegalArgumentException("Invalid quantity!");
        }
        this.qty = qty;
    }

    @Override
    public String toString(){
        return getClass().getName() + "[name=" + name + "," + author.toString() + ",price=" + price + ", quantity=" + qty + "]";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            Author a1 = new Author("Tan Ah Teck", "ahteck@nowhere.edu.vn");
            System.out.println(a1);

            a1.setEmail("ahteck@somewhere.com");
            System.out.println(a1);
            System.out.println("name is: " + a1.getName());
            System.out.println("email is: " + a1.getEmail());

            // Test Book class
            Book b1 = new Book("12345", "Java for dummies", a1, 8.8, 88);
            System.out.println(b1);

            b1.setPrice(9.9);
            b1.setQty(99);
            System.out.println(b1.toString());
            System.out.println("isbn is: " + b1.getIsbn());
            System.out.println("name is: " + b1.getName());
            System.out.println("price is: " + b1.getPrice());
            System.out.println("qty is: " + b1.getQty());
            System.out.println("author is: " + b1.getAuthor().toString());  // Author's toString()
            System.out.println("author's name: " + b1.getAuthor().getName());
            System.out.println("author's email: " + b1.getAuthor().getEmail());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
