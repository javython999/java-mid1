package time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class ChangeTimeWithMain {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 1,13, 30, 59);
        System.out.println("localDateTime: " + localDateTime);

        LocalDateTime changeDt0 = localDateTime.with(ChronoField.YEAR, 2020);
        System.out.println("changeDt0: " + changeDt0);


        LocalDateTime changeDt1 = localDateTime.withYear(2020);
        System.out.println("changeDt2: " + changeDt1);

        // TemporalAdjuster 사용
        LocalDateTime nextFriday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("기준 날짜: " + localDateTime);
        System.out.println("다음 금요일: " + nextFriday);

        // 이번 달의 마지막 요일
        LocalDateTime lastSunday = localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("lastSunday: " + lastSunday);
    }
}
