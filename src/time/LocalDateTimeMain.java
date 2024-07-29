package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {

    public static void main(String[] args) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime ofDateTime = LocalDateTime.of(2024, 7, 28, 21, 0);

        System.out.println("현재 시간 = " + nowDateTime);
        System.out.println("지정 시간 = " + ofDateTime);

        // 날짜와 시간 분리
        LocalDate localDate = ofDateTime.toLocalDate();
        LocalTime localTime = ofDateTime.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        // 날짜와 시간 합체
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        // 계산(불변)
        ofDateTime = ofDateTime.plusDays(1000);
        System.out.println("ofDateTime = " + ofDateTime);

        LocalDateTime ofDatePlusYear = ofDateTime.plusYears(1);
        System.out.println(ofDatePlusYear);

        // 비교
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가? " + nowDateTime.isBefore(ofDatePlusYear));
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가? " + nowDateTime.isAfter(ofDatePlusYear));
        System.out.println("현재 날짜와 시간이 지정 날짜시간이 같은가? " + nowDateTime.isEqual(ofDatePlusYear));
    }
}
