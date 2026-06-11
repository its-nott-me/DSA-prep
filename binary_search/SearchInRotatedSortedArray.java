/*
    Problem: Search in Rotated Sorted Array

    Description:
    Given a rotated sorted array nums (with distinct values) and a target,
    return its index if found, otherwise return -1.

    Approach: Modified Binary Search

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - At least one half (left or right) is always sorted
    - Check which half is sorted:
        1. If left half is sorted:
            - Check if target lies in this range
            - If yes → search left, else → search right
        2. Else right half is sorted:
            - Check if target lies in this range
            - If yes → search right, else → search left

    Notes:
    - Works because rotation preserves sorted halves
    - No duplicates assumed
*/

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while(s <= e){
            int m = s + (e - s) / 2;

            if(nums[m] == target) return m;

            // left half is sorted
            if(nums[s] <= nums[m]){
                if(nums[s] <= target && target < nums[m]){
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } 
            // right half is sorted
            else {
                if(nums[m] < target && target <= nums[e]){
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(sol.search(nums, target)); // Output: 4
    }
}