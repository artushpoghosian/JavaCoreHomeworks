package medicalCenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.util.Scanner;

public class DateUtil {

    private static final String DATE_PATTERN = "dd-MM-yyyy";

    public static Date readDateFromInput(Scanner sc) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        formatter.setLenient(false);

        Date date = null;
        while (date == null) {
            System.out.println("Enter the Registration Date (" + DATE_PATTERN + "):");
            String input = sc.nextLine();
            try {
                date = formatter.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter in " + DATE_PATTERN + " format:");
            }
        }
        return date;
    }

    public static String formatDate(Date date) {
        if (date == null) return "";
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.format(date);
    }
}
