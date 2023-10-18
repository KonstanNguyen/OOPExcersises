
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
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price){
        this.name = name;
        this.authors = authors;
        setPrice(price);
    }

    public Book(String name, Author[] author, double price, int qty){
        this(name, author, price);
        setQty(qty);
    }

    public String getName(){
        return name;
    }

    public Author[] getAuthors(){
        return authors;
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
        String result = getClass().getName() + "[name=" + name + ",";

        for(Author author : authors){
            result += author.toString() + ",";
        }
        result += "price=" + price + ", quantity=" + qty + "]";

        return result;
    }

    public String getAuthorNames(){
        int size = authors.length;
        String[] authorNames = new String[size];
        for(int i = 0; i < size; i++){
            authorNames[i] = authors[i].getName();
        }
        
        return String.join(",", authorNames);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            // Declare and allocate an array of Authors
            Author[] authors = {
                new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'),
                new Author("Paul Tan", "Paul@nowhere.com", 'm')
            };

            Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
            System.out.println(javaDummy);  // toString()

            System.out.println(javaDummy.getAuthorNames());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}