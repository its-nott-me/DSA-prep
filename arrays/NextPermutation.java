/*
    Problem: Next Permutation

    Description:
    Given an array of integers representing a permutation, rearrange it
    into the next lexicographically greater permutation. If such arrangement
    is not possible, rearrange it into the lowest possible order (sorted ascending).

    Approach: Greedy + Reversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Find the first decreasing element from the right (pivot)
    - If no pivot exists, array is in descending order → reverse it
    - Otherwise:
        - Find the next greater element to swap with pivot
        - Swap pivot with that element
        - Reverse the suffix to get the smallest order

    Notes:
    - Works in-place
    - Standard lexicographical permutation algorithm
*/

class NextPermutation {

    public void swap(int nums[], int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void reverse(int nums[], int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;

        // find first decreasing element
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }

        // if no next permutation exists
        if(i == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;

        // find element just greater than pivot
        while(nums[j] <= nums[i - 1]){
            j--;
        }

        // swap pivot with successor
        swap(nums, i - 1, j);

        // reverse suffix
        reverse(nums, i, nums.length - 1);
    }

    public static void main(String[] args){
        NextPermutation sol = new NextPermutation();

        int[] nums = {1, 2, 3};

        sol.nextPermutation(nums);

        for(int x : nums){
            System.out.print(x + " ");
        }
        // Output: 1 3 2
    }
}