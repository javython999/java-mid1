package lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {

    public static void main(String[] args) {

        // 현재 시간(밀리초)를 가져온다.
        long currentTime = System.currentTimeMillis();
        System.out.println("current time: " + currentTime);

        // 현재 시간(나노초)를 가져온다.
        long currentNanoTime = System.nanoTime();
        System.out.println("nano time: " + currentNanoTime);

        // 환경 변수를 읽는다.
        System.out.println("getenv = " + System.getenv());

        // 시스템 속성을 읽는다.
        System.out.println("properties = " + System.getProperties());

        // 배열을 고속으로 복사한다.
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        System.out.println("copied array: " + copiedArray);
        System.out.println("copied array: " + Arrays.toString(copiedArray));

        // 프로그램 종료
        System.exit(0);
        System.out.println("!");

    }
}
