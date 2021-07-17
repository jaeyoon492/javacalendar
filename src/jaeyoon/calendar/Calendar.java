package jaeyoon.calendar;


public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public int getLeapMaxDaysOfMonth(int month) {
        return LEAP_MAX_DAYS[month - 1];
    }

    public void printCalendar(int year, int month) {
        System.out.printf("  << %4d년%3d월 >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println(" --------------------");

        int maxDay = getMaxDaysOfMonth(month);
        int leapMaxDay = getLeapMaxDaysOfMonth(month);

        if (isLeapYear(year)) {
            printCalendar(leapMaxDay);
        } else {
            printCalendar(maxDay);
        }
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void printCalendar(int day) {
        for (int i = 1; i <= day; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
