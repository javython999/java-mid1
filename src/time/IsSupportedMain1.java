package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportedMain1 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        if (now.isSupported(ChronoField.SECOND_OF_MINUTE)) {
            System.out.println("SECOND_OF_MINUTE = " +  now.get(ChronoField.SECOND_OF_MINUTE));
        } else {
            System.out.println("NOT_SUPPORTED " + ChronoField.SECOND_OF_MINUTE);
        }
    }
}
