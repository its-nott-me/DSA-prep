/*
    Problem: Find First and Last Position of Element in Sorted Array

    Description:
    Given a sorted array nums and a target value, return the starting
    and ending position of the target. If not found, return [-1, -1].

    Approach: Binary Search (Two Pass)

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - Perform two binary searches:
        1. Find first occurrence (leftmost index)
        2. Find last occurrence (rightmost index)
    - On finding target:
        - For first occurrence → continue search on left side
        - For last occurrence → continue search on right side

    Notes:
    - Do not stop at first match
    - Narrow search space to find boundaries
*/

class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        // find first occurrence
        int s = 0, e = nums.length - 1;
        while(s <= e){
            int m = s + (e - s) / 2;

            if(nums[m] < target){
                s = m + 1;
            } 
            else if(nums[m] > target){
                e = m - 1;
            } 
            else {
                res[0] = m;
                e = m - 1; // move left
            }
        }

        // find last occurrence
        s = 0;
        e = nums.length - 1;

        while(s <= e){
            int m = s + (e - s) / 2;

            if(nums[m] < target){
                s = m + 1;
            } 
            else if(nums[m] > target){
                e = m - 1;
            } 
            else {
                res[1] = m;
                s = m + 1; // move right
            }
        }

        return res;
    }

    public static void main(String[] args){
        FindFirstAndLastPosition sol = new FindFirstAndLastPosition();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] res = sol.searchRange(nums, target);

        System.out.println(res[0] + " " + res[1]); // Output: 3 4
    }
}