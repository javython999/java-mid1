package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {

    public static void main(String[] args) throws ClassNotFoundException {
        // Class 조회
        Class clazz0 = String.class;  // 1. 클래스에서 조회
        Class clazz1 = new String().getClass(); // 2. 인스턴스에서 조회
        Class clazz2 = Class.forName("java.lang.String"); // 3. 문자열로 조회

        // 모든 필드 출력
        Field[] declaredFields = clazz0.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field: " + field.getName());
        }

        // 모든 메서드 출력
        Method[] declaredMethods = clazz0.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method: " + method.getName());
        }

        // 상위 클래스 정보 출력
        System.out.println("Superclass: " + clazz0.getSuperclass());

        // 인터페이스 정보 출력
        Class[] interfaces = clazz0.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println("interface: " + inter);
        }
    }
}
