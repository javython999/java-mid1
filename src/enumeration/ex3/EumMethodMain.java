package enumeration.ex3;

import java.util.Arrays;

public class EumMethodMain {

    public static void main(String[] args) {
        // 모든 ENUM 반환
        Grade[] values = Grade.values();
        System.out.println(Arrays.toString(values));

        for (Grade grade : values) {
            System.out.println("name = " + grade.name() + ", ordinal = " + grade.ordinal());
        }

        // String -> ENUM 변환
        String input = "GOLD";
        Grade goldGrade = Grade.valueOf(input);
        System.out.println("name = " + goldGrade.name() + ", ordinal = " + goldGrade.ordinal());


    }
}
