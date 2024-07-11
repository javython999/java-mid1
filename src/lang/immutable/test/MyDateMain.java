package lang.immutable.test;

public class MyDateMain {

    public static void main(String[] args) {
        MyDate myDate = new MyDate(2024, 1, 1);

        MyDate myDate2 = myDate;

        myDate.setYear(2024);

        System.out.println("myDate =" + myDate);
        System.out.println("myDate2 =" + myDate2);
    }
}
