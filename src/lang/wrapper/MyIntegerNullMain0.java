package lang.wrapper;

public class MyIntegerNullMain0 {

    public static void main(String[] args) {
        int[] intArry = {-1, 0, 1, 2, 3};

        System.out.println(findValue(intArry, -1));
        System.out.println(findValue(intArry, 0));
        System.out.println(findValue(intArry, 1));
        System.out.println(findValue(intArry, 100));
    }

    private static int findValue(int[] intArry, int target) {
        for (int value : intArry) {
            if (value == target) {
                return value;
            }
        }
        return -1;
    }
}
