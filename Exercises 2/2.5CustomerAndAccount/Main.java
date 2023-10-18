class Customer{
    private int id;
    private String name;
    private char gender;

    public Customer(int id, String name, char gender){
        if(id < 0) throw new IllegalArgumentException("Invalid id!");
        if(gender != 'm' && gender != 'f') throw new IllegalArgumentException("Invalid gender!");
        
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public char getGender(){
        return gender;
    }

    public String toString(){
        return name + "(" + id + ")";
    }
}

class Account{
    private int id;
    private Customer customer;
    private double balance = 0.0;

    public Account(int id, Customer customer, double balance){
        this(id, customer);
        setBalance(balance);
    }

    public Account(int id, Customer customer){
        if(id < 0) throw new IllegalArgumentException("Invalid id!");
        this.id = id;
        this.customer = customer;
    }

    public int getId(){
        return id;
    }

    public Customer getCustomer(){
        return customer;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        if(balance < 0) throw new IllegalArgumentException("Invalid balance!");
        this.balance = balance;
    }

    @Override
    public String toString(){
        String strBalance = String.format("%.2f", balance);
        return customer.toString() + " balance=" + strBalance;
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public Account deposit(double amount){
        if(amount < 0) throw new IllegalArgumentException("Invalid amount!");
        balance += amount;
        return this;
    }

    public Account withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }else{
            System.out.println("amount withdrawn exceeds the current balance!");
        }
        return this;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            // Declare a customer
            Customer customer = new Customer(123, "Nguyen", 'm');
            System.out.println(customer.toString());

            //Test public methods in customer class
            System.out.println("Id: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Gender: " + customer.getGender());

            //Declare a customer's account
            Account account = new Account(22, customer, 1000);
            System.out.println(account.toString());

            //Test public methods in account class
            System.out.println("Id: " + account.getId());
            System.out.println("Customer: " + account.getCustomerName());
            System.out.println("Balance: " + account.getBalance());
            account = account.deposit(1000);
            System.out.println(account.toString());
            account = account.withdraw(100);
            System.out.println(account.toString());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
