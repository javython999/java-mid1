package lang.string.method;

import java.util.Arrays;

public class StringUtils {

    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object obj = new Object();
        String str = "Hello, Java!";

        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값 = " + numString);

        String boolString = String.valueOf(bool);
        System.out.println("불리언의 문자열 값 = " + boolString);

        String objString = String.valueOf(obj);
        System.out.println("객체의 문자열 값 = " + objString);

        char[] strCharArray = str.toCharArray();
        System.out.println(Arrays.toString(strCharArray));

        String format = String.format("num: %d, bool: %b, str: %s", num, bool, str);
        System.out.println(format);

        System.out.println(String.format("숫자: %.2f", 3.14159265358979));

        String regex = "Hello, (Java!|World)";
        System.out.println(str.matches(regex));
    }
}
