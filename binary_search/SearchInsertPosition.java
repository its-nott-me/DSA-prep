/*
    Problem: Search Insert Position

    Description:
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found. If not, return the index
    where it would be inserted to maintain sorted order.

    Approach: Binary Search

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - Perform standard binary search
    - If target is found → return its index
    - If not found → the pointer 's' will be at the correct insert position

    Notes:
    - 's' always points to the smallest index where target can be inserted
    - Works because search space converges to insertion point
*/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while(s <= e) {
            int m = s + (e - s) / 2;

            if(nums[m] == target) return m;

            if(nums[m] < target)
                s = m + 1;
            else
                e = m - 1;
        }

        return s;
    }

    public static void main(String[] args){
        SearchInsertPosition sol = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(sol.searchInsert(nums, target)); // Output: 2
    }
}