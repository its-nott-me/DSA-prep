/*
    Problem: Check if Array is Sorted and Rotated

    Description:
    Given an array nums, determine whether it is sorted in non-decreasing order
    and then rotated at some pivot (possibly zero rotations).

    Approach: Linear Scan

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Count the number of places where the order breaks (nums[i] > nums[i+1])
    - Also check the wrap-around condition between last and first element
    - A valid sorted-rotated array will have at most one such break

    Notes:
    - If count of breaks > 1, array is not sorted & rotated
*/

class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1])
                count++;
        }

        if(nums[n - 1] > nums[0]) 
            count++;

        return count < 2;
    }

    public static void main(String[] args){
        CheckIfArrayIsSortedAndRotated sol = new CheckIfArrayIsSortedAndRotated();

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(sol.check(nums)); // Output: true
    }
}