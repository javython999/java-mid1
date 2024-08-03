package time.test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestPlus {

    public static void main(String[] args) {
        // 2024년 1월 1일 0시 0분 0초에 1년 2개월 3일 4시간 후의 시각을 찾아라

        LocalDateTime standardTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        LocalDateTime afterTime = standardTime.plusYears(1)
                                              .plusMonths(2)
                                              .plusDays(3)
                                              .plusHours(4);
        System.out.println("afterTime = " + afterTime);

        // 2024년 1월 1일부터 2주 간격으로 5번 반복하여 날짜를 출력
        LocalDate startDate0 = LocalDate.of(2024, 1, 1);

        for (int i = 0; i < 5; i++) {
            System.out.println(startDate0.plusWeeks(2 * i));
        }

        // 시작 날짜와 목표 날짜를 입력해서 남은 기간과 디데이를 구해라

        LocalDate startDay = LocalDate.of(2024, 1, 1);
        LocalDate endDay = LocalDate.of(2024, 11, 21);

        Period between = Period.between(startDay, endDay);
        System.out.println("between = " + between.getMonths() + "개월 " + between.getDays() + "일");
        long daysBetween = ChronoUnit.DAYS.between(startDay, endDay);
        System.out.println("daysBetween = " + daysBetween);


        // 입력 받은 월의 첫날 요일과 마지막날의 요일을 구해라
        int year = 2024;
        int month = 1;

        LocalDate date = LocalDate.of(year, month, 1);

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        LocalDate lastDate = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDate = " + lastDate.getDayOfWeek());

        // 서울의 회의 시간은 2024년 1월 1일 오전 9시이다. 이때 런던, 뉴욕의 회의 시간을 구하라

        ZonedDateTime seoulTime = ZonedDateTime.of(LocalDateTime.of(2024, 1, 1, 9, 0, 0), ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonTime = seoulTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newyorkTime = seoulTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("seoulTime = " + seoulTime);
        System.out.println("londonTime = " + londonTime);
        System.out.println("newyorkTime = " + newyorkTime);

    }
}
