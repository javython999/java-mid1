package nested.anonymous.ex0;

public class Ex0RefMain {

    public static void hello(String message) {
        System.out.println("프로그램 시작");
        System.out.println(message);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello("Hello Java");
        hello("Hello Spring");
    }
}
