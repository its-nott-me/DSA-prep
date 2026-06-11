/*
    Problem: Find Minimum in Rotated Sorted Array

    Description:
    Given a rotated sorted array of unique elements, return the minimum element.
    The array was originally sorted in ascending order and then rotated.

    Approach: Binary Search

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - The minimum element lies in the unsorted part of the array
    - Compare middle element with the rightmost element:
        - If nums[m] > nums[e] → minimum lies in right half
        - Else → minimum lies in left half (including m)
    - Narrow down search space until s == e

    Notes:
    - Works because array has no duplicates
    - Final index 's' points to the minimum element
*/

class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;

        // edge case
        if(nums.length == 1) return nums[0];

        while(s < e){
            int m = s + (e - s) / 2;

            if(nums[m] > nums[e]){
                s = m + 1;
            } else {
                e = m;
            }
        }

        return nums[s];
    }

    public static void main(String[] args){
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(sol.findMin(nums)); // Output: 1
    }
}