package medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String fromDateToString(Date date) {
        return sdf.format(date);
    }

    public static Date fromStringToDate(String str) throws ParseException {
        return sdf.parse(str);
    }
}
