
class Author{
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender){
        this.name = name;
        setEmail(email);
        if(gender == 'f' || gender == 'm'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Invalid gender!");
        }
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(email.contains(".com") || email.contains(".student.edu.vn")){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid email!");
        }
    }

    public char getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return getClass().getName() + "[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}

class Book{
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(String name, Author author, double price){
        this.name = name;
        this.author = author;
        setPrice(price);
    }

    public Book(String name, Author author, double price, int qty){
        this(name, author, price);
        setQty(qty);
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
            Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm'); // Test the constructor
            System.out.println(ahTeck.toString());  // Test toString()
            ahTeck.setEmail("paulTan@nowhere.com");  // Test setter
            System.out.println("Name is: " + ahTeck.getName());     // Test getter
            System.out.println("Eamil is: " + ahTeck.getEmail());   // Test getter
            System.out.println("Gender is: " + ahTeck.getGender()); // Test gExerciseOOP_MyPolynomial.pngetter

            Book dummyBook = new Book("Java for dummy", ahTeck, 19.95, 99);  // Test Book's Constructor
            System.out.println(dummyBook);  // Test Book's toString()

            // Test Getters and Setters of Book
            dummyBook.setPrice(29.95);
            dummyBook.setQty(28);
            System.out.println("Name is: " + dummyBook.getName());
            System.out.println("Price is: " + dummyBook.getPrice());
            System.out.println("Quantity is: " + dummyBook.getQty());
            System.out.println("Author is: " + dummyBook.getAuthor().toString());  // Author's toString()
            System.out.println("Author's name is: " + dummyBook.getAuthor().getName());
            System.out.println("Author's email is: " + dummyBook.getAuthor().getEmail());

            // Use an anonymous instance of Author to construct a Book instance
            Book anotherBook = new Book("More Java", 
                new Author("Paul Tan", "paul@somewhere.com", 'm'), 29.95);
            System.out.println(anotherBook.toString());  // toString()
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}