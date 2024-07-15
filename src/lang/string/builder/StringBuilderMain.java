package lang.string.builder;

public class StringBuilderMain {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);

        sb.insert(4, "Java");
        System.out.println("insert = " + sb);

        sb.delete(4, 8);
        System.out.println("delete = " + sb);

        System.out.println("reverse = " + sb.reverse());

        String string = sb.toString();
        System.out.println("string = " + string);
    }
}
