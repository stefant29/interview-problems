import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.youtube.com/watch?v=9Y2GoDcf44w
public class Solution {
    
    public static int get_digit(int index, int number) {
        return number / (int)Math.pow(10, index);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < n; grid_j++){
                if (grid_i == 0 || grid_j == 0 || grid_i == n-1 || grid_j == n-1) {
                    System.out.print(grid[grid_i].charAt(grid_j));
                    continue;
                }
                if (grid[grid_i].charAt(grid_j) > grid[grid_i].charAt(grid_j-1) && 
                   grid[grid_i].charAt(grid_j) > grid[grid_i].charAt(grid_j+1) && 
                   grid[grid_i].charAt(grid_j) > grid[grid_i-1].charAt(grid_j) && 
                   grid[grid_i].charAt(grid_j) > grid[grid_i+1].charAt(grid_j) )
                    System.out.print("X");
                else
                    System.out.print(grid[grid_i].charAt(grid_j));
            }
            System.out.println();
        }
    }
}
