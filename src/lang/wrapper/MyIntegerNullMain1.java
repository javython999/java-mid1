package lang.wrapper;

public class MyIntegerNullMain1 {

    public static void main(String[] args) {
        MyInteger[] intArry = {new MyInteger(-1), new MyInteger(0), new MyInteger(1), new MyInteger(2), new MyInteger(3)};

        System.out.println(findValue(intArry, -1));
        System.out.println(findValue(intArry, 0));
        System.out.println(findValue(intArry, 1));
        System.out.println(findValue(intArry, 100));
    }

    private static MyInteger findValue(MyInteger[] intArry, int target) {
        for (MyInteger myInteger : intArry) {
            if (myInteger.getValue() == target) {
                return myInteger;
            }
        }
        return null;
    }
}
