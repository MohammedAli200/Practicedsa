package Day22;

public class Car {
    public static void sound(){
        System.out.println("car makes sound");
    }
}
class ElectricCar extends Car{
    public static void sound(){
        System.out.println("electric car makes sound");
    }
    static void main() {
        sound();
    }
}
