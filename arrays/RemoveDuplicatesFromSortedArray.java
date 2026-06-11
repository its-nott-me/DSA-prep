/*
    Problem: Remove Duplicates from Sorted Array

    Description:
    Given a sorted integer array nums, remove duplicates in-place such that
    each unique element appears only once. Return the number of unique elements.

    Approach: Two Pointers

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Since array is sorted, duplicates are adjacent
    - Use one pointer to traverse the array
    - Use another pointer to place unique elements
    - Whenever a new unique element is found, move it forward

    Notes:
    - Modification is done in-place
    - Only first k elements of array are valid after processing
*/

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] != nums[i + 1])
                nums[++j] = nums[i + 1];
        }

        return j + 1;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1, 1, 2, 2, 3};

        int k = sol.removeDuplicates(nums);

        System.out.println(k); // Output: 3
    }
}