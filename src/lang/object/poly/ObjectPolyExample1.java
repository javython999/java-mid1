package lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    private static void action(Object object) {
        // object.sound() // 컴파일 에러, Object는 sound()가 없다.
        // object.move() // 컴파일 에러, Object는 move()가 없다.

        // 객체에 맞는 다운캐스팅 필요
        if (object instanceof Dog dog) {
            dog.sound();
        } else if (object instanceof Car car) {
            car.move();
        }
    }
}
