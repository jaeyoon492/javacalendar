package jaeyoon.calendar;

import java.util.*;

public class Prompt {

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }

    public void runPrompt() {
        displayInputMessage();
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        String delimeter = "-";

        while (true) {
            System.out.println("명령(1, 2, 3, h, q)");
            String cmd = scanner.next();
            if (cmd.equals("1")) cmdRegister();
            else if (cmd.equals("2")) cmdSearch();
            else if (cmd.equals("3")) printCal(scanner, delimeter, cal);
            else if (cmd.equals("h")) displayInputMessage();
            else if (cmd.equals("q")) break;

        }
        System.out.println("Bye~");
        scanner.close();
    }

    private void printCal(Scanner scanner, String delimeter, Calendar cal) {
        List<Integer> dateList = new ArrayList();
        String date = getDate(scanner);

        String[] dateArr = split(delimeter, date);
        parse(dateArr, dateList);

        int year = dateList.get(0);
        int month = dateList.get(1);
        if (check(month)) return;
        int day = dateList.get(2);

        int days = cal.getNumOfDays(year, month);
        cal.printCalendar(year, month, days);
    }

    private void cmdSearch() {
    }

    private void cmdRegister() {
    }

    private void displayInputMessage() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록 ");
        System.out.println("| 2. 일정 검색 ");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
    }

    private void parse(String[] dateArr, List dateList) {
        for (int i = 0; i < dateArr.length; i++) {
            dateList.add(Integer.parseInt(dateArr[i]));
        }
    }

    private String[] split(String delimeter, String date) {
        String[] dateArr = date.split(delimeter);
        return dateArr;
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

    private String getDate(Scanner userInput) {
        System.out.println("년도를 입력하세요. ex : yyyy-mm-dd");
        return userInput.next();
    }
}
