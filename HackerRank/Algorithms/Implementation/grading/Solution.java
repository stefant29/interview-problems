import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/grading
public class Solution {
    static int[] solve(int n, int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 38) {
                int roundedGrade = (int)Math.floor((grades[i]+4)/5)*5;
                if (roundedGrade - grades[i] < 3) {
                    grades[i] = roundedGrade;
                    continue;
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(n, grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
      
    }
}
