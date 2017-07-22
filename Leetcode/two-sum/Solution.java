import java.util.Arrays;

// https://leetcode.com/problems/two-sum
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        solution[0] = 0;
        solution[1] = 0;
 
        //Simple solution:
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }

/*        //sort the list
        Arrays.sort(nums);
        
        //take one element and look for (SUM-element) in the list
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (target < sum)
                    break;
                if (sum == target) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
 */       
        System.out.println("No solution found");
        return solution;
    }
}