package Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public static String standard_format = "dd/MM/yyyy";
    public static String date_picker_format = "MMMM/dd/yyyy";
    public static String date_picker_short_month_format = "MMM d, yyyy";
    public static String date_picker_full_month_format = "MMMM d, yyyy";


    public static String generateDateInFutureWithFormat(int dateToAdd, String format) {
        String date = addDate(dateToAdd);
        SimpleDateFormat sdf = new SimpleDateFormat(standard_format);
        try {
            Date d = sdf.parse(date);
            sdf.applyPattern(format);
            return sdf.format(d);
        } catch (ParseException ex) {
            ex.getMessage();
            return "ERROR ...";
        }
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat(standard_format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getNextMonday(int noOfWeek) {
        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        if (weekday != Calendar.MONDAY) {
            int days = (Calendar.SATURDAY + 7 - weekday + 2) % 7;
            now.add(Calendar.DAY_OF_YEAR, days);
            now.add(Calendar.DAY_OF_YEAR, 7 * noOfWeek);
        } else {
            now.add(Calendar.DAY_OF_YEAR, 7 * noOfWeek);
        }
        Date date = now.getTime();
        DateFormat dateFormat = new SimpleDateFormat(standard_format);
        return dateFormat.format(date);
    }

    public static String convertToDatePickerFormat(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(standard_format);
        Date x = sdf.parse(date);
        sdf.applyPattern(date_picker_format);
        return sdf.format(x);
    }

    public static String convertToDatePickerShortMonthFormat(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(standard_format);
        Date x = sdf.parse(date);
        sdf.applyPattern(date_picker_full_month_format);
        return sdf.format(x);
    }

    public static long generateTimeStampInEpoch(int addedDate) {
        try {
            String dateString = generateDateInFutureWithFormat(addedDate, standard_format);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(standard_format);
            Date date = simpleDateFormat.parse(dateString);
            long epoch = date.getTime() / 1000;
            Timestamp timestamp = new Timestamp(date.getTime());
            return epoch;
        } catch (Exception e) {
            e.printStackTrace();
            return 1588870800;
        }
    }

    public static long getCurrentTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    private static String addDate(int dateToAdd) {
        String currentDate = getCurrentDate();
        SimpleDateFormat sdf = new SimpleDateFormat(standard_format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(currentDate));
        } catch (ParseException e) {
            e.getMessage();
        }
        calendar.add(Calendar.DATE, dateToAdd);
        return sdf.format(calendar.getTime());
    }
}
