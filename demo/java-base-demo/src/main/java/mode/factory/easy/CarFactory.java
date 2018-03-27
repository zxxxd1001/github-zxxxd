package mode.factory.easy;

public class CarFactory {
    public static Car createCar(){
        return new Car();
    }

    public static void main(String[] args) {
        Car c=CarFactory.createCar();
    }
}
class Car{

}
