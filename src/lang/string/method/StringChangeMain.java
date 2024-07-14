package lang.string.method;

public class StringChangeMain {

    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java";

        System.out.println("인덱스 7부터의 부분 문자열 :" + str.substring(7));
        System.out.println("인덱스 7부터 12까지의 문자열: " + str.substring(7, 12));
        System.out.println("문자열 결합: " + str.concat("!!!!"));
        System.out.println("'Java'를 'World'로 대체: " + str.replace("Java", "World"));
        System.out.println("첫 번째 'Java'를 'World'로 대체: " + str.replaceFirst("Java", "World"));


        String strWithSpace = "     Java Programming ";
        System.out.println("소문자로 변환 : " + strWithSpace.toLowerCase());
        System.out.println("대문자로 변환 : " + strWithSpace.toUpperCase());
        System.out.println("공백제거(trim) : '" +  strWithSpace.trim() + "'");
        System.out.println("공백제거(strip) : '" +  strWithSpace.strip() + "'");
        System.out.println("앞 공백 제거(stripLeading) : '" +  strWithSpace.stripLeading() + "'");
        System.out.println("뒤 공백 제거(stripTrailing) : '" +  strWithSpace.stripTrailing() + "'");

        String strSplit = "Apple,Banana,Orange";

        String[] split = strSplit.split(",");

        for (String s : split) {
            System.out.println(s);
        }

        String join = String.join("-", split);
        System.out.println("join : " + join);


    }
}
