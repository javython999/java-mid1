package lang.string.test;

public class TestString {

    public static void main(String[] args) {
        String url = "https://www.example.com";

        boolean isHttps = url.startsWith("https");

        System.out.println("isHttps = " + isHttps);

        String[] arr = {"hello", "java", "jvm", "spring", "jap"};
        int sum = 0;
        for (String str : arr) {
            System.out.println(str + ":" + str.length());
            sum += str.length();
        }
        System.out.println("sum = " + sum);


        String indexOfTest = "hello.txt";
        System.out.println("indexOf .text = " + indexOfTest.indexOf(".txt"));

        String filenName = indexOfTest.substring(0, 5);
        String extName = indexOfTest.substring(5, indexOfTest.length());
        System.out.println("filenName = " + filenName);
        System.out.println("extName = " + extName);

        String key = "hello";
        String countString = "start hello java, hello spring hello jpa";

        int count = 0;
        int startIndex = countString.indexOf(key);
        while (startIndex != -1) {
            startIndex = countString.indexOf(key, startIndex + 1);
            count ++;
        }
        System.out.println("count = " + count);


        String whitespace = "           Hello Java ";
        String removeWhitespace = whitespace.strip();
        System.out.println("removeWhitespace = '" + removeWhitespace + "'");

        String input = "hello java spring jpa";
        String replace = input.replace("hello", "jvm");
        System.out.println("replace = " + replace);

        String email = "hello@example.com";
        String[] split = email.split("@");
        System.out.printf("id = %s | domain = %s\n", split[0], split[1]);

        String fruits = "apple,banana,mango";
        String[] fruitsList = fruits.split(",");
        for (String fruit : fruitsList) {
            System.out.println(fruit);
        }

        String join = String.join("->", fruitsList);
        System.out.println("join = " + join);
    }
}
