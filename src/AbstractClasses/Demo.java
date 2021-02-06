package AbstractClasses;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Here's the abstract!");

        Parrot parrot = new Parrot("Australian Longneck");

        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("emporrer");
        penguin.fly();
    }
}
