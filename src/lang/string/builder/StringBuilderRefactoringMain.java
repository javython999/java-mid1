package lang.string.builder;

public class StringBuilderRefactoringMain {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A")
                .append("B")
                .append("C")
                .append("D")
                .insert(4, "Java")
                .reverse()
                .toString();

        System.out.println("sb = " + sb);
    }
}
