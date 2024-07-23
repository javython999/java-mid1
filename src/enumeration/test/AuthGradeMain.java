package enumeration.test;

public class AuthGradeMain {

    public static void main(String[] args) {
        AuthGrade[] grades = AuthGrade.values();

        for (AuthGrade grade : grades)
            System.out.println(grade.name() + " Level=" + grade.getLevel() + ", 설명=" +  grade.getDescription());
        }
    }
}
