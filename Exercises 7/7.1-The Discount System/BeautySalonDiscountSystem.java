import java.util.Date;

class DiscountRate {
  // Static variables
  private static double premiumDiscountRate = 0.20;
  private static double goldDiscountRate = 0.15;
  private static double silverDiscountRate = 0.10;
  private static double productDiscountRate = 0.10;

  public static double getServiceDiscount(String type) {
    if (type.equalsIgnoreCase("Premium")) {
      return premiumDiscountRate;
    } else if (type.equalsIgnoreCase("Gold")) {
      return goldDiscountRate;
    } else if (type.equalsIgnoreCase("Silver")) {
      return silverDiscountRate;
    } else {
      return 0.0;
    }
  }

  public static double getProductDiscount() {
    return productDiscountRate;
  }
}

class Customer {
  private String name;
  private boolean member = false;
  private String memberType;

  public Customer(String name, String memberType) {
    this.name = name;
    this.memberType = memberType;
  }

  public String getName() {
    return name;
  }

  public boolean isMember() {
    return member;
  }

  public void setMember(boolean member) {
    this.member = member;
  }

  public String getMemberType() {
    return memberType;
  }

  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }

  public String toString(){
    return getClass().getName() + "[name=" + name + ",isMember=" + member + ",memberType=" + memberType + "]";
  }
}

class Visit {
  private Customer customer;
  private Date date;
  private double productsExpense;
  private double servicesExpense;

  public Visit(Customer customer, double productsExpense, double servicesExpense) {
    this.customer = customer;
    this.productsExpense = productsExpense;
    this.servicesExpense = servicesExpense;
  }

  // public String getName(){
  //   return customer.getName();
  // }

  public double getServiceExpense(){
    return servicesExpense;
  }

  public void setServiceExpense(double expense){
    servicesExpense = expense;
  }

  public double getProductExpense(){
    return productsExpense;
  }

  public void setProductExpense(double expense){
    productsExpense = expense;
  }

  public double getTotalExpense() {
    double serviceDiscount = DiscountRate.getServiceDiscount(customer.getMemberType());
    double productDiscount = DiscountRate.getProductDiscount();

    double discountedServicesExpense = servicesExpense * (1 - serviceDiscount);
    double discountedProductsExpense = productsExpense * (1 - productDiscount);

    return discountedServicesExpense + discountedProductsExpense;
  }

  public String toString(){
    return getClass().getName() + "[Customer=" + customer + ",Date=" + date + ",servicesExpense=" + servicesExpense + ",productsExpense=" + productsExpense + "]";
  }
}

public class BeautySalonDiscountSystem {
  public static void main(String[] args) {
    // Create customer objects
    Customer premiumCustomer = new Customer("Alice", "Premium");
    Customer goldCustomer = new Customer("Bob", "Gold");
    Customer silverCustomer = new Customer("Charlie", "Silver");
    Customer regularCustomer = new Customer("David", "Regular");

    // Create visit objects
    Visit visit1 = new Visit(premiumCustomer, 100, 200);
    Visit visit2 = new Visit(goldCustomer, 150, 250);
    Visit visit3 = new Visit(silverCustomer, 80, 150);
    Visit visit4 = new Visit(regularCustomer, 120, 180);

    // Calculate and print total bills
    System.out.println(premiumCustomer.getName() + "'s total bill: $" + visit1.getTotalExpense());
    System.out.println(goldCustomer.getName() + "'s total bill: $" + visit2.getTotalExpense());
    System.out.println(silverCustomer.getName() + "'s total bill: $" + visit3.getTotalExpense());
    System.out.println(regularCustomer.getName() + "'s total bill: $" + visit4.getTotalExpense());
  }
}
