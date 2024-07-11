package lang.immutable.change;

public class ImmutableMain {

    public static void main(String[] args) {
        ImmutableObj immutableObj = new ImmutableObj(10);
        ImmutableObj immutableObj2 = immutableObj.add(20);

        System.out.println(immutableObj);
        System.out.println(immutableObj2);
    }
}
