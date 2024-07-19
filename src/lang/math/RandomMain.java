package lang.math;

import java.util.Random;

public class RandomMain {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("randomInt: " + random.nextInt());
        System.out.println("randomDouble: " + random.nextDouble()); // 0.0d ~ 1.0d
        System.out.println("randomBoolean: " + random.nextBoolean());
        System.out.println("randomRange0: " + random.nextInt(10)); // 0 ~ 9
        System.out.println("randomRange1 "  + random.nextInt(10 + 1)); // 1 ~ 10

        Random seed = new Random(1); // seed가 같으면 랜덤의 결과가 같다.
        System.out.println("randomInt: " + seed.nextInt());
        System.out.println("randomDouble: " + seed.nextDouble()); // 0.0d ~ 1.0d
        System.out.println("randomBoolean: " + seed.nextBoolean());
        System.out.println("randomRange0: " + seed.nextInt(10)); // 0 ~ 9
        System.out.println("randomRange1 "  + seed.nextInt(10 + 1)); // 1 ~ 10
    }
}
