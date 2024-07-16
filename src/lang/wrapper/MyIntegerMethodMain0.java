package lang.wrapper;

public class MyIntegerMethodMain0 {

    public static void main(String[] args) {
        int value = 10;

        int result1 = compareTo(10, 5);
        System.out.println(result1);

        int result2 = compareTo(value, 10);
        System.out.println(result2);

        int result3 = compareTo(value, 20);
        System.out.println(result3);
    }

    public static int compareTo(int value, int target) {
        return value < target ? -1 : value > target ? 1 : 0;
    }
}
