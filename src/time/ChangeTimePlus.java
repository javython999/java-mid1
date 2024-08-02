package time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlus {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 1, 13, 30, 59);

        LocalDateTime plusDT0 = localDateTime.plus(10, ChronoUnit.YEARS);
        System.out.println("plusDT0: " + plusDT0);

        LocalDateTime plusDT1 = localDateTime.plusYears(10);
        System.out.println("plusDT1: " + plusDT1);

        Period period = Period.ofYears(10);
        LocalDateTime plusDT2 = localDateTime.plus(period);
        System.out.println("plusDT2: " + plusDT2);
    }
}
