package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10);
        Integer integerObj = Integer.valueOf(10);
        Integer integerCache = Integer.valueOf(10);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);

        Long longObj = Long.valueOf(100);
        System.out.println("longObj = " + longObj);

        Double doubleObj = Double.valueOf(10.5);
        System.out.println("doubleObj = " + doubleObj);

        System.out.println("내부 값 읽기");

        int intValue = integerObj.intValue();
        System.out.println("intValue = " + intValue);

        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        double doubleValue = doubleObj.doubleValue();
        System.out.println("doubleValue = " + doubleValue);

        System.out.println("== :" + (newInteger == integerObj));
        System.out.println("equals :" + (newInteger.equals(integerObj)));
        System.out.println("cache :" + (integerCache == integerObj));
    }
}
