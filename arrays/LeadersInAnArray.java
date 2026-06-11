/*
    Problem: Leaders in an Array

    Description:
    An element is called a leader if it is greater than or equal to all
    the elements to its right. The rightmost element is always a leader.

    Approach: Right to Left Scan

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Traverse the array from right to left
    - Keep track of the maximum element seen so far
    - If current element is greater than max, it is a leader
    - Reverse the result at the end to maintain original order

    Notes:
    - Last element is always a leader
    - Efficient single-pass solution from the end
*/

import java.util.*;

class LeadersInArray {
    public List<Integer> leaders(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > max) {
                res.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){
        LeadersInArray sol = new LeadersInArray();

        int[] nums = {16, 17, 4, 3, 5, 2};

        List<Integer> res = sol.leaders(nums);

        for(int x : res){
            System.out.print(x + " ");
        }
        // Output: 17 5 2
    }
}