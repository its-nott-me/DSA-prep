/*
    Problem: Binary Search

    Description:
    Given a sorted array nums and a target value, return the index of the
    target if it exists. Otherwise, return -1.

    Approach: Binary Search

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - Repeatedly divide the search space in half
    - Compare target with middle element
    - If equal → return index
    - If target is smaller → search left half
    - If target is larger → search right half

    Notes:
    - Array must be sorted
    - Use (start + (end - start) / 2) to avoid overflow
*/

class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int m = start + (end - start) / 2;

            if(nums[m] == target){
                return m;
            }

            if(nums[m] > target){
                end = m - 1;
            } else {
                start = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        BinarySearch sol = new BinarySearch();

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(sol.search(nums, target)); // Output: 4
    }
}