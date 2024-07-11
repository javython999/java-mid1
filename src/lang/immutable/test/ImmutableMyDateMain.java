package lang.immutable.test;

public class ImmutableMyDateMain {

    public static void main(String[] args) {
        ImmutableMyDate myDate = new ImmutableMyDate(2024, 1, 1);
        ImmutableMyDate myDate2 = myDate.withYear(2025);


        System.out.println("myDate = " + myDate);
        System.out.println("myDate2 = " + myDate2);
    }
}
