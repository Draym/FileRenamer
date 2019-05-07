package tools;

import java.util.Calendar;
import java.util.Date;

public class DateTools {

    public static Date addHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(date); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, hour); // adds one hour
        return cal.getTime();
    }
}
