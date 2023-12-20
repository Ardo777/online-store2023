package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy | hh:mm");

    public static long ConvertMinIntoMs(int min){
        return min * 60000L;
    }

    public static Date StringToDate (String dateStr) throws ParseException {
        return SDF.parse(dateStr);
    }

    public static String dateToString (Date date) throws ParseException {
        return SDF.format(date);
    }
}
