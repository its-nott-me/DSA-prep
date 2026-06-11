/*
    Problem: Search in Rotated Sorted Array II

    Description:
    Given a rotated sorted array nums that may contain duplicates,
    return true if target exists in the array, otherwise return false.

    Approach: Modified Binary Search (Handling Duplicates)

    Time Complexity: O(log n) on average, O(n) in worst case (due to duplicates)
    Space Complexity: O(1)

    Key Idea:
    - Similar to rotated binary search, but duplicates make it tricky
    - If nums[s] == nums[m] == nums[e], we cannot determine sorted half
      → shrink search space (s++, e--)
    - Otherwise:
        1. If left half is sorted:
            - Check if target lies within [s, m)
        2. Else right half is sorted:
            - Check if target lies within (m, e]

    Notes:
    - Duplicates can degrade performance to linear time
    - Always check for target match inside loop
*/

class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;

        int s = 0, e = nums.length - 1;

        while(s <= e){
            int m = s + (e - s) / 2;

            if(nums[m] == target) return true;

            // handle duplicates
            if(nums[s] == nums[m] && nums[m] == nums[e]){
                s++;
                e--;
            }
            // left half sorted
            else if(nums[s] <= nums[m]){
                if(nums[s] <= target && target < nums[m]){
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
            // right half sorted
            else {
                if(nums[m] < target && target <= nums[e]){
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArrayII sol = new SearchInRotatedSortedArrayII();

        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        System.out.println(sol.search(nums, target)); // Output: true
    }
}