package lang.string;

public class StringConcatMain {

    public static void main(String[] args) {
        String a = "hello";
        String b = " java";

        String resul1 = a.concat(b);
        String resul2 = a + b;

        System.out.println("result1 = " + resul1);
        System.out.println("result2 = " + resul2);
    }
}
