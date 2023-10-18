
class Customer{
    private int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount){
        if(id < 0) throw new IllegalArgumentException("Invalid id!");
        this.id = id;
        this.name = name;
        setDiscount(discount);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getDiscount(){
        return discount;
    }

    public void setDiscount(int discount){
        if(discount < 0) throw new IllegalArgumentException("Invalid discount!");
        this.discount = discount;
    }

    @Override
    public String toString(){
        return name + "(" + id + ")(" + discount + "%)";
    }
}

class Invoice{
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount){
        if(id < 0) throw new IllegalArgumentException("Invalid id!");
        this.id = id;
        setCustomer(customer);
        setAmount(amount);
    }

    public int getId(){
        return id;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public double getAmount(){
        return amount;
    }    

    public void setAmount(double amount){
        if(amount < 0) throw new IllegalArgumentException("Invalid amount!");
        this.amount = amount;
    }

    public int getCustomerId(){
        return customer.getId();
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public int getCustomerDiscount(){
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount(){
        return amount - (amount * getCustomerDiscount());
    }

    @Override
    public String toString(){
        return getClass().getName() + "[id=" + id + ",customer=" + customer.toString() + ",amount=" + amount + "]";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            Customer c1 = new Customer(88, "Tan Ah Teck", 10);
            System.out.println(c1);  // Customer's toString()

            c1.setDiscount(8);
            System.out.println(c1);
            System.out.println("Id is: " + c1.getId());
            System.out.println("Name is: " + c1.getName());
            System.out.println("Discount is: " + c1.getDiscount());

            // Test Invoice class
            Invoice inv1 = new Invoice(101, c1, 888.8);
            System.out.println(inv1);

            inv1.setAmount(999.9);
            System.out.println(inv1);
            System.out.println("Id is: " + inv1.getId());
            System.out.println("Customer is: " + inv1.getCustomer());  // Customer's toString()
            System.out.println("Amount is: " + inv1.getAmount());
            System.out.println("Customer's id is: " + inv1.getCustomerId());
            System.out.println("Customer's name is: " + inv1.getCustomerName());
            System.out.println("Customer's discount is: " + inv1.getCustomerDiscount());
            System.out.printf("Amount after discount is: %.2f%n", inv1.getAmountAfterDiscount());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
