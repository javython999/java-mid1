package enumeration.ref2;


import java.util.Arrays;

public class ClassGradeRef2Main {

    public static void main(String[] args) {
        int price = 10_000;

        Arrays.stream(Grade.values())
                .forEach(grade ->
                    System.out.println(grade.name() + ": " + grade.getDiscount(price))
                );
    }
}
