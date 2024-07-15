package lang.string.chaining;

public class MethodChainingMain {

    public static void main(String[] args) {
        ValueAdder valueAdder = new ValueAdder();
        valueAdder.add(1);
        valueAdder.add(2);
        valueAdder.add(3);

        int result = valueAdder.getValue();
        System.out.println("result: " + result);

        ValueAdder valueAdder2 = new ValueAdder();
        ValueAdder valueAdder2_1 = valueAdder2.add(1);
        ValueAdder valueAdder2_2 = valueAdder2_1.add(2);
        ValueAdder valueAdder2_3 = valueAdder2_2.add(3);

        System.out.println("valueAdder2_1: " + valueAdder2_1);
        System.out.println("valueAdder2_2: " + valueAdder2_2);
        System.out.println("valueAdder2_3: " + valueAdder2_2);

        ValueAdder chaining = new ValueAdder();
        int chainResult = chaining.add(1).add(2).add(3).getValue();
        System.out.println("chainResult: " + chainResult);

    }
}
