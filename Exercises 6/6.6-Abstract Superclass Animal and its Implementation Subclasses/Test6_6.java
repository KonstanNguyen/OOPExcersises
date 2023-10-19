import java.util.ArrayList;

abstract class Animal {
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  abstract public void greets();
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  @Override
  public void greets() {
    System.out.println("Meow");
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void greets() {
    System.out.println("Woof");
  }

  public void greets(Dog another) {
    System.out.println("Woooof");
  }
}

class BigDog extends Dog {
  public BigDog(String name) {
    super(name);
  }

  public void greets() {
    System.out.println("Wooow");
  }

  public void greets(Dog another) {
    System.out.println("Woooooow");
  }

  public void greets(BigDog another) {
    System.out.println("Woooooooooooooow");
  }
}

public class Test6_6 {
  public static void main(String[] args) {
    // Using the subclasses
    Cat cat1 = new Cat("Kitty");
    cat1.greets();
    Dog dog1 = new Dog("Pug");
    dog1.greets();
    BigDog bigDog1 = new BigDog("Bob");
    bigDog1.greets();

    // Using Polymorphism
    Animal animal1 = new Cat("Katy");
    animal1.greets();
    Animal animal2 = new Dog("Lucky");
    animal2.greets();
    Animal animal3 = new BigDog("BigBoy");
    animal3.greets();

    // Downcast
    Dog dog2 = (Dog) animal2;
    BigDog bigDog2 = (BigDog) animal3;
    Dog dog3 = (Dog) animal3;
    dog2.greets(dog3);
    dog3.greets(dog2);
    dog2.greets(bigDog2);
    bigDog2.greets(dog2);
    bigDog2.greets(bigDog1);
  }
}
