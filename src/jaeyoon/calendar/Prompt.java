package jaeyoon.calendar;

import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();


        while (true) {
            int year = setYear(scanner);
            int month = setMonth(scanner);
            if (month == -1) {
                break;
            }
            if (month > 12) {
                System.out.println("5252~ 그런 월은 없다구~");
                continue;
            }
            cal.printCalendar(year, month);
        }
        System.out.println("Bye~");
    }


    private int setMonth(Scanner scanner) {
        int month;
        System.out.println("달을 입력하세요.");
        System.out.print(PROMPT);
        month = scanner.nextInt();
        return month;
    }


    private int setYear(Scanner scanner) {
        int year;
        System.out.println("몇년도 달력인가요?");
        System.out.print(PROMPT);
        year = scanner.nextInt();
        return year;
    }


    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
