import java.util.ArrayList;

class Animal{
  private String name;

  public Animal(String name){
    this.name = name;
  }

  public String toString(){
    return getClass().getName() + "[" + name + "]";
  }
}

class Mammal extends Animal{
  public Mammal(String name){
    super(name);
  }

  public String toString(){
    return super.toString();
  }
}

class Cat extends Mammal{
  public Cat(String name){
    super(name);
  }

  public void greets(){
    System.out.println("Meow");
  }

  public String toString(){
    return super.toString();
  }
}

class Dog extends Mammal{
  public Dog(String name){
    super(name);
  }

  public void greets(){
    System.out.println("Woof");
  }

  public void greets(Dog another){
    System.out.println("Woooof");
  }

  public String toString(){
    return super.toString();
  }
}

public class Test4_6{
  public static void main(String[] args){
    ArrayList<Animal> animals = new ArrayList<>();

    animals.add(new Animal("Bob"));
    animals.add(new Mammal("Jimmy"));
    animals.add(new Cat("Dien"));
    animals.add(new Dog("Thuy"));

    for(Animal animal : animals){
      System.out.println(animal.toString());
      if(animal instanceof Cat){
        ((Cat)animal).greets();
      }
      if(animal instanceof Dog){
        ((Dog)animal).greets();
        ((Dog)animal).greets(new Dog("Thuong"));
      }
    }
  }
}
