/*
    Problem: Maximum Subarray

    Description:
    Given an integer array nums, find the contiguous subarray
    (containing at least one number) which has the largest sum
    and return its sum.

    Approach: Kadane’s Algorithm

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Maintain a running sum (curr) of the subarray
    - If curr becomes negative, restart from current element
    - Otherwise, extend the subarray
    - Track the maximum sum seen so far

    Notes:
    - Negative prefix is discarded because it reduces future sum
    - Optimal linear-time solution
*/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i = 0; i < nums.length; i++){
            if(curr < 0){
                curr = nums[i];
            } else {
                curr += nums[i];
            }

            max = Math.max(max, curr);
        }

        return max;
    }

    public static void main(String[] args){
        MaximumSubarray sol = new MaximumSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(sol.maxSubArray(nums)); // Output: 6
    }
}