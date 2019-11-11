package mode.factory.easy;

public class TestCarFactory {
    public static void main(String[] args) {
        Car c=CarFactory.createCar();
    }
}
class CarFactory {
    public static Car createCar(){
        return new Car();
    }
}
class Car{

}
