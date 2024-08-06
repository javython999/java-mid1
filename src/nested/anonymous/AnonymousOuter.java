package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        Printer localPrinter = new Printer() {
            int value = 0;

            @Override
            public void print() {
                System.out.println("value: " + value);
                System.out.println("localVar: " + localVar);
                System.out.println("paramVar: " + paramVar);
                System.out.println("outInstanceVar: " + outInstanceVar);
            }
        };

        localPrinter.print();
        System.out.println("localPrinter.class=" + localPrinter.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter localOuter = new AnonymousOuter();
        localOuter.process(2);
    }
}
