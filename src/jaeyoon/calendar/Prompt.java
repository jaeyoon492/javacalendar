package jaeyoon.calendar;

import java.util.Scanner;

public class Prompt {

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }

    /*
     * param week : 요일명
     * return : 0 ~ 6 (0 = 일요일, 6 = 토요일)
     * */
//    public int parseDay(String week) {
//        if (week.equals("su")) {
//            return 0;
//        } else if (week.equals("mo")) {
//            return 1;
//        } else if (week.equals("tu")) {
//            return 2;
//        } else if (week.equals("we")) {
//            return 3;
//        } else if (week.equals("th")) {
//            return 4;
//        } else if (week.equals("fr")) {
//            return 5;
//        } else if (week.equals("sa")) {
//            return 6;
//        } else {
//            return 0;
//        }
//    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            int year = getYear(scanner);
            if (checker(year)) break;

            int month = getMonth(scanner);
            if (check(month)) continue;

            int days = cal.getNumOfDays(year, month);

            cal.printCalendar(year, month, days);
        }
        System.out.println("Bye~");
    }


    private boolean check(int month) {
        if (month > 12 || month < 1) {
            System.out.println("5252~ 그런 월은 없다구~");
            return true;
        }
        return false;
    }

    private boolean checker(int exit) {
        if (exit == -1) {
            return true;
        }
        return false;
    }

    private int getMonth(Scanner userInput) {
        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        return userInput.nextInt();
    }


    private int getYear(Scanner userInput) {
        System.out.println("몇년도 달력인가요?(exit : -1)");
        System.out.print("YEAR> ");
        return userInput.nextInt();
    }
}
