package time;

import java.time.ZoneId;

public class ZoneIdMain {

    public static void main(String[] args) {

        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(ZoneId.of(zoneId).getRules());
        }

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault(): " + zoneId);
    }
}
