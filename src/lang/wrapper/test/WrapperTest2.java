package lang.wrapper.test;

public class WrapperTest2 {

    public static void main(String[] args) {
        String str = "100";
        
        // parsing
        Integer integerValue0 = Integer.valueOf(str);
        System.out.println("Integer Value: " + integerValue0);
        System.out.println("Integer Class: " + integerValue0.getClass().getName());

        // Integer -> int
        int intValue0 = integerValue0.intValue();
        System.out.println("intValue0: " + intValue0);

        // int -> Integer
        Integer integerValue1 = Integer.valueOf(intValue0);
        System.out.println("integerValue1: " + integerValue1);
        System.out.println("integerValue1 Class: " + integerValue1.getClass().getName());


        // parsing
        Integer integerValue2 = Integer.valueOf(str);

        // Integer -> int
        int intValue1 = integerValue2;
        Integer integerValue3 = intValue1;

    }
}
