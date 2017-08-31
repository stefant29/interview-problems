import java.util.Scanner;
import java.time.LocalDate;

// https://www.hackerrank.com/challenges/java-date-and-time
public class Solution {
    public static String getDay(String day, String month, String year) {
        
        LocalDate dt = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        String s = dt.getDayOfWeek().toString();
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
    }
}