package lang.wrapper;

public class AutoboxingMain {

    public static void main(String[] args) {
        int value = 7;
        Integer boxedValue = Integer.valueOf(value);

        int unboxed = boxedValue.intValue();

        Integer autoBoxing = value;
        int autoUnboxing = autoBoxing;
    }
}
