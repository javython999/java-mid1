package time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {

    public static void main(String[] args) {
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value: " + value);
        }

        System.out.println("HOURS = " + ChronoUnit.HOURS);
        System.out.println("HOURS.duration = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println("DAYS = " + ChronoUnit.DAYS.getDuration().getSeconds());


        LocalTime localTime0 = LocalTime.of(1, 10, 0);
        LocalTime localTime1 = LocalTime.of(1, 20, 0);

        long between = ChronoUnit.SECONDS.between(localTime0, localTime1);
        System.out.println("between: " + between);

        long minuatesBetween = ChronoUnit.MINUTES.between(localTime0, localTime1);
        System.out.println("minuatesBetween: " + minuatesBetween);
    }
}
