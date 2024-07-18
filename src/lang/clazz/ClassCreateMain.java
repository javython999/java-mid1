package lang.clazz;

import java.lang.reflect.InvocationTargetException;

public class ClassCreateMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class helloClass0 = Hello.class;
        Class helloClass1 = Class.forName("lang.clazz.Hello");

        Hello hello = (Hello) helloClass0.getDeclaredConstructor().newInstance();
        System.out.println(hello.hello());
    }
}
