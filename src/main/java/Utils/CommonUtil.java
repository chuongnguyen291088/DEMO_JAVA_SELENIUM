package Utils;

import Core.Support.PropertyBuilder;
import org.testng.Assert;

import java.util.ArrayList;

import static Constants.WeekDayConstants.*;

public class CommonUtil {
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String removeLineBreaks(String input) {
        return input.replace("\n", "").replace("\r", "");
    }

    public static String convertWeekDayToInteger(String weekday) {
        String returnedDay = "";
        switch (weekday.toUpperCase()) {
            case MONDAY:
                returnedDay = "1";
                break;
            case TUESDAY:
                returnedDay = "2";
                break;
            case WEDNESDAY:
                returnedDay = "3";
                break;
            case THURSDAY:
                returnedDay = "4";
                break;
            case FRIDAY:
                returnedDay = "5";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + weekday.toUpperCase());
        }
        return returnedDay;
    }

    public static void verifyArraySize(ArrayList<?> arr, int expectedSize) {
        Assert.assertEquals(arr.size(), expectedSize, String.format("Expect size [%s] but actual is [%s]", expectedSize, arr.size()));
    }

    public static void verifyArraySizeGreaterThan(ArrayList<?> arr, int expectedSize) {
        Assert.assertTrue(arr.size() > expectedSize, String.format("Expect Array Size should be greater than [%s], but actual array size is [%s]", expectedSize, arr.size()));
    }

    public String getUserName() {
        return PropertyBuilder.getEnvProperty().getProperty("login.name");
    }

    public String getUserEmail() {
        return PropertyBuilder.getEnvProperty().getProperty("login.email");
    }
}
