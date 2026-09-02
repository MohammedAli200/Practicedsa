package Day22;

public class Animal {
    public void sound(){
        System.out.println("Animal make sound");
    }
}
class Dog extends Animal{
    public void sound(){
        System.out.println("dog makes barking");
    }
}

class Cat extends Animal{
    public void sound(){
        System.out.println("cat meowss");
    }
}

class Cow extends Animal{
    public void sound(){
        System.out.println("cow mowwwwwss");
    }
}

class Main{
    static void main() {
        Animal[] animals={
                new Dog(),
                new Cat(),
                new Cow()
        };
        for(Animal animal:animals){
            animal.sound();
        }
    }
}