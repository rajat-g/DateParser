package com.github;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class DateParserUtil {

    public static DateWithFormat getDateWithFormat(String stringDate, boolean preferMonthFirst, boolean prefer24HourTime) {
        if (Objects.nonNull(stringDate)) {
            stringDate = stringDate.trim();
            String format = getFormat(stringDate, preferMonthFirst, prefer24HourTime);
            if (Objects.nonNull(format)) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                try {
                    Date date = sdf.parse(stringDate);
                    return new DateWithFormat(date, format);
                } catch (ParseException e) {
                    System.out.println("Format:" + format);
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * This method returns the format of String date based on separator and length
     *
     * @param stringDate
     * @param preferMonthFirst
     * @return
     */
    private static String getFormat(String stringDate, boolean preferMonthFirst, boolean prefer24HourTime) {
        String format = null;
        if (stringDate.contains(",")) {
            format = getFormatWithTime(stringDate, "MMM dd, yyyy", prefer24HourTime);
        } else if (stringDate.contains("-")) {
            //first dash contains 4 digits or 2 that is DB format or MM-dd-yyyy/dd-MM-yyyy format
            int first = stringDate.substring(0, stringDate.indexOf("-")).length();
            if (first == 4) {
                format = getFormatWithTime(stringDate, "yyyy-MM-dd", prefer24HourTime);
            } else {
                preferMonthFirst = getPreferMonthFirst(preferMonthFirst, stringDate, "-");
                format = getFormatBasedOnDisplayFormat(stringDate, "MM-dd-yyyy", "dd-MM-yyyy",
                        preferMonthFirst, prefer24HourTime);
            }
        } else if (stringDate.contains("/")) {
            preferMonthFirst = getPreferMonthFirst(preferMonthFirst, stringDate, "/");
            format = getFormatBasedOnDisplayFormat(stringDate, "MM/dd/yyyy", "dd/MM/yyyy",
                    preferMonthFirst, prefer24HourTime);
        }
        return format;
    }

    /**
     * This method returns format based on DISPLAY FORMAT Constant
     *
     * @param stringDate
     * @param usDateFormat
     * @param indianDateFormat
     * @param preferMonthFirst
     * @return
     */
    private static String getFormatBasedOnDisplayFormat(String stringDate, String usDateFormat, String indianDateFormat,
                                                        boolean preferMonthFirst, boolean prefer24HourTime) {
        String format;
        if (preferMonthFirst) {
            format = getFormatWithTime(stringDate, usDateFormat, prefer24HourTime);
        } else {
            format = getFormatWithTime(stringDate, indianDateFormat, prefer24HourTime);
        }
        return format;
    }


    private static String getFormatWithTime(String stringDate, String format, boolean prefer24HourTime) {
        if (stringDate.contains(":")) {
            prefer24HourTime = getPrefer24HourTime(prefer24HourTime, stringDate, format);
            String hourString = prefer24HourTime ? "HH" : "hh";
            long timeSeparatorCount = stringDate.chars().filter(num -> num == ':').count();
            if (timeSeparatorCount == 2) {
                if (stringDate.length() == format.length() + 9) {
                    format = format + " " + hourString + ":mm:ss";
                } else { //(stringDate.length() == format.length() + 12)
                    format = format + " hh:mm:ss a";
                }
            } else { //(timeSeparatorCount == 1)
                if (stringDate.length() == format.length() + 6) {
                    format = format + " " + hourString + ":mm";
                } else { //(stringDate.length() == format.length() + 9)
                    format = format + " hh:mm a";
                }
            }
        }
        return format;
    }

    /**
     * if first number is greater than 12 and second number is smaller than 12 then return `false`
     * that is first digit is `date` and second digit should be `month`
     * if first number is smaller than 12 and second number is greater than 12 then return `true`
     * that is first digit is `month` and second digit should be `date`
     * else if both are less than 12 or greater than 12 return user passed preferMonthFirst
     *
     * @param preferMonthFirst
     * @param stringDate
     * @param separator
     * @return
     */
    private static boolean getPreferMonthFirst(boolean preferMonthFirst, String stringDate, String separator) {
        String firstNumberAsString = stringDate.substring(0, stringDate.indexOf(separator));
        String secondNumberAsString = stringDate.substring(stringDate.indexOf(separator) + 1, stringDate.lastIndexOf(separator));
        int firstNumber = Integer.parseInt(firstNumberAsString);
        int secondNumber = Integer.parseInt(secondNumberAsString);
        if (firstNumber > 12 && secondNumber < 12) {
            return false;
        } else if (firstNumber < 12 && secondNumber > 12) {
            return true;
        }
        return preferMonthFirst;
    }


    /**
     * if first number is greater than 12 then return `true`
     * that is first digit is in 24 hour format else return user passed prefer24HourTime
     * @param prefer24HourTime
     * @param stringDate
     * @param format
     * @return
     */
    private static boolean getPrefer24HourTime(boolean prefer24HourTime, String stringDate, String format) {
        String time = stringDate.substring(format.length()).trim();
        String separator = ":";
        String firstNumberAsString = time.substring(0, time.indexOf(separator));
        int firstNumber = Integer.parseInt(firstNumberAsString);
        if (firstNumber > 12) {
            return true;
        }
        return prefer24HourTime;
    }
}