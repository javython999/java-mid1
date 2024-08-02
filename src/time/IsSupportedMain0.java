package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportedMain0 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int minute = now.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println("Minute: " + minute);
    }
}
