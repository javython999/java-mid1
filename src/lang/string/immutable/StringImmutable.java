package lang.string.immutable;

public class StringImmutable {

    public static void main(String[] args) {
        String str = "hello";
        String concat = str.concat("java");
        System.out.println("str = " + str);
        System.out.println("concat = " + concat);
    }
}
