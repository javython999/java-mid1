package lang.wrapper.test;

public class WrapperTest1 {

    public static void main(String[] args) {
        String str0 = "10";
        String str1 = "20";

        int num0 = Integer.parseInt(str0);
        int num1 = Integer.parseInt(str1);
        System.out.println("sum = " + (num0 + num1));

        String[] array = {"1.5", "2.5", "3.0"};
        double sum = 0;
        for (String str : array) {
            sum += Double.parseDouble(str);
        }
        System.out.println("sum = " + sum);
    }
}
