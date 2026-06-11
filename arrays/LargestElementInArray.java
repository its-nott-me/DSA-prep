/*
Problem: Largest Element in Array

Description:
Given an integer array nums, return the largest element in the array.

Approach: Linear Scan

Time Complexity: O(n)
Space Complexity: O(1)

    Key Idea:
    - Traverse the array once
    - Keep track of the maximum element seen so far
    - Update max whenever a larger element is found
    
    Notes:
    - Simple greedy scan
    - No extra space required
*/

class LargestElementInArray {
    public int largestElement(int[] nums) {
        int max = nums[0];

        for(int i : nums){
            max = Math.max(max, i);
        }

        return max;
    }

    public static void main(String[] args){
        LargestElementInArray sol = new LargestElementInArray();

        int[] nums = {3, 10, 6, 2, 8};

        int result = sol.largestElement(nums);

        System.out.println(result); // Output: 10
    }
}
