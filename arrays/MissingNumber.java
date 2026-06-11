/*
    Problem: Missing Number

    Description:
    Given an array nums containing n distinct numbers taken from the range
    [0, n], return the one number that is missing from the array.

    Approach: XOR Trick

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - XOR of a number with itself cancels out (a ^ a = 0)
    - XOR of a number with 0 is the number itself
    - So XORing all numbers from 0 to n and all array elements leaves only the missing number

    How it works:
    - xor_nums stores XOR of array elements
    - xor_range stores XOR of full range [0...n]
    - Final answer = xor_nums ^ xor_range
*/

class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, xor_range = 0, xor_nums = 0;

        for(int num : nums){
            xor_range ^= i;   // XOR of indices 0 to n-1
            xor_nums ^= num;  // XOR of array elements
            i++;
        }

        xor_range ^= nums.length; // include n in range XOR

        return xor_nums ^ xor_range;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums = {3, 0, 1};

        int result = sol.missingNumber(nums);

        System.out.println(result); // Output: 2
    }
}