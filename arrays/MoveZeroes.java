/*
    Problem: Move Zeroes

    Description:
    Given an integer array nums, move all 0's to the end of it while
    maintaining the relative order of the non-zero elements.

    Approach: Two Pointers

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use one pointer to iterate through the array
    - Use another pointer to place non-zero elements at the front
    - After processing all elements, fill remaining positions with 0

    Notes:
    - Maintains relative order of non-zero elements
    - In-place modification without extra array
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0, n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0)
                nums[j++] = nums[i];
        }

        while(j < n){
            nums[j++] = 0;
        }
    }

    public static void main(String[] args){
        MoveZeroes sol = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};

        sol.moveZeroes(nums);

        for(int x : nums){
            System.out.print(x + " ");
        }
        // Output: 1 3 12 0 0
    }
}