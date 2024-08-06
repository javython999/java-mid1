package nested.test;

public class AnonymousMain {

    public static void main(String[] args) {
        Hello anonymousHello = new Hello() {
            @Override
            public void hello() {
                System.out.println("Anonymous Hello");
            }
        };

        anonymousHello.hello();
    }
}
