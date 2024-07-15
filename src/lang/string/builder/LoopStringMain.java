package lang.string.builder;

public class LoopStringMain {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello World!";
        }

        long endTime = System.currentTimeMillis();
        System.out.println(result.getBytes());
        System.out.println("time = " + (endTime - startTime) + "ms");


        System.out.println("----------------------------------------------------");

        startTime = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            builder.append("Hello World!");
        }

        endTime = System.currentTimeMillis();

        System.out.println("time = " + (endTime - startTime));
    }
}
