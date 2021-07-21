package jaeyoon.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap<Date, String> planMap;

    public Calendar() {
        planMap = new HashMap<Date, String>();
    }

    //@param date ex: 2021-07-21
    public void registerPlan(String strDate, String plan) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
        planMap.put(date, plan);
    }

    public String searchPlan(String strDate) throws ParseException{
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
        String plan = planMap.get(date);
        return plan;
    }

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public int getLeapMaxDaysOfMonth(int month) {
        return LEAP_MAX_DAYS[month - 1];
    }

    public int getNumOfDays(int year, int month) {
        int preYear = year - 1;
        int numOfDays = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);
        boolean leafYear = ((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0));

        for (int i = 0; i < month - 1; i++) {
            numOfDays += MAX_DAYS[i];
        }

        if (month >= 3 && leafYear) {
            numOfDays++;
        }

        numOfDays++; //입력받은 월의 1일을 계산하므로 + 1
        return numOfDays;
    }

    public void printCalendar(int year, int month, int days) {
        System.out.printf("  << %4d년%3d월 >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println(" --------------------");

        //get weekday automatically
        int weekDay = days % 7;

        for (int i = 0; i < weekDay; i++) {
            System.out.print("   ");
        }

        int maxDay = getMaxDaysOfMonth(month);
        int leapMaxDay = getLeapMaxDaysOfMonth(month);

        if (check(year)) {
            printCalendar(leapMaxDay, weekDay);
        } else {
            printCalendar(maxDay, weekDay);
        }
    }

    private boolean check(int year) {
        boolean leafYear = ((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0));

        if (leafYear) {
            return true;
        } else {
            return false;
        }
    }

    private void printCalendar(int day, int weekDay) {
        int count = 7 - weekDay;

        //print first line
        for (int i = 1; i <= count; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        //print second line
        for (int i = count + 1; i <= day; i++) {
            System.out.printf("%3d", i);
            if (weekDay == 0 && i % 7 == 0) {
                System.out.println();
            } else if (i % 7 == count) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
