/*
    Problem: Linear Search

    Description:
    Given an integer array nums and a target value, return the index of the
    target if it exists in the array. If not found, return -1.

    Approach: Linear Scan

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Traverse the array from left to right
    - Compare each element with the target
    - Return index immediately when found
    - If not found, return -1
*/

class LinearSearch {
    public int linearSearch(int nums[], int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        }

        return -1;
    }

    public static void main(String[] args){
        LinearSearch sol = new LinearSearch();

        int[] nums = {4, 2, 7, 1, 9};
        int target = 7;

        System.out.println(sol.linearSearch(nums, target)); // Output: 2
    }
}