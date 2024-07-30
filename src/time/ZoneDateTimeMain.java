package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeMain {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Now: " + now);

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2030, 1, 1, 13, 30, 50, 0, ZoneId.of("Asia/Seoul"));
        System.out.println("ZonedDateTime1: " + zonedDateTime1);
    }
}
