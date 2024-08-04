package nested.inner;

public class InnerOuterMain {

    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();

        InnerOuter.Inner inner = outer.new Inner();

        System.out.println("innerClass = " + inner.getClass());
        inner.print();
    }
}