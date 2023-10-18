import java.util.ArrayList;

class Person{
  private String name;
  private String address;

  public Person(String name, String address){
    this.name = name;
    this.address = address;
  }

  public String getName(){
    return name;
  }

  public String getAddress(){
    return address;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public String toString(){
    return getClass().getName() + "[name=" + name + ",address=" + address + "]";
  }
}

class Student extends Person{
  private String program;
  private int year;
  private double fee;

  public Student(String name, String address, String program, int year, double fee){
    super(name, address);
    setProgram(program);
    setYear(year);
    setFee(fee);
  }

  public String getProgram(){
    return program;
  }

  public void setProgram(String program){
    this.program = program;
  }

  public int getYear(){
    return year;
  }

  public void setYear(int year){
    if(year < 1 || year > 9999) throw new IllegalArgumentException("Invalid year!");
    this.year = year;
  }

  public double getFee(){
    return fee;
  }

  public void setFee(double fee){
    if(fee < 0) throw new IllegalArgumentException("Invalid fee!");
    this.fee = fee;
  }

  public String toString(){
    return super.toString() + "[program=" + program + ",year=" + year + ",fee=" + fee + "]";
  }
}

class Staff extends Person{
  private String school;
  private double pay;

  public Staff(String name, String address, String school, double pay){
    super(name, address);
    setSchool(school);
    setPay(pay);
  }

  public String getSchool(){
    return school;
  }

  public void setSchool(String school){
    this.school = school;
  }

  public double getPay(){
    return pay;
  }

  public void setPay(double pay){
    if(pay < 0) throw new IllegalArgumentException("Invalid pay!");
    this.pay = pay;
  }

  public String toString(){
    return super.toString() + "[school=" + school + ",pay=" + pay + "]";
  }
}

public class N21DCCN156{
  public static void main(String[] args){
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(new Person("John", "USA"));
    persons.add(new Student("Jame", "UK", "Engineering", 2022, 50000));
    persons.add(new Staff("Jimmy", "Australia", "FPT", 1000));

    for (Person person : persons){
      System.out.println(person.toString());
    }
  }
}
