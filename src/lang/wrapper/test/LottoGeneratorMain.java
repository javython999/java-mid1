package lang.wrapper.test;

import java.util.Arrays;

public class LottoGeneratorMain {

    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        int[] generate = generator.generate();
        System.out.println(Arrays.toString(generate));
    }
}
