/*
    Problem: Rotate Array

    Description:
    Given an integer array nums, rotate the array to the right by k steps,
    where k is non-negative.

    Approach: Reverse Array (In-place)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Normalize k using k = k % n
    - Reverse the entire array
    - Reverse first k elements
    - Reverse remaining n-k elements

    Notes:
    - Uses in-place reversal technique
    - Efficient and avoids extra space
*/

class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start_idx, int end_idx){
        while(start_idx < end_idx){
            int temp = nums[start_idx];
            nums[start_idx] = nums[end_idx];
            nums[end_idx] = temp;

            start_idx++;
            end_idx--;
        }
    }

    public static void main(String[] args){
        RotateArray sol = new RotateArray();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        sol.rotate(nums, 3);

        for(int x : nums){
            System.out.print(x + " ");
        }
        // Output: 5 6 7 1 2 3 4
    }
}