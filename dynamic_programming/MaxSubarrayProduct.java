/*
    Problem: Maximum Product Subarray

    Description:
    Given an integer array nums, find the contiguous subarray within the array
    that has the largest product and return that product.

    Approach: Dynamic Programming (Track Maximum and Minimum Products)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - At each index, maintain:
        1. maxProductHere -> maximum product ending at current index
        2. minProductHere -> minimum product ending at current index
    - We track the minimum product because multiplying a negative number
      by another negative number can produce a new maximum product.
    - For each element, calculate the new maximum and minimum products
      considering:
        * Current number itself
        * Current number × previous maximum product
        * Current number × previous minimum product
    - Update the global maximum product throughout the traversal.

    Notes:
    - Negative numbers can flip the sign of the product.
    - A very small (negative) product may become the largest product later.
    - The answer is guaranteed to be found during the single pass.
*/


public class MaxSubarrayProduct {
    public int maxProduct(int[] nums) {
        int maxProductHere = nums[0];
        int minProductHere = nums[0];
        int globalMax = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int newMax = Math.max(num, Math.max(maxProductHere*num, minProductHere*num));
            int newMin = Math.min(num, Math.min(minProductHere*num, maxProductHere*num));

            maxProductHere = newMax;
            minProductHere = newMin;

            globalMax = Math.max(globalMax, newMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        MaxSubarrayProduct solution = new MaxSubarrayProduct();

        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2, 3, -4};

        System.out.println("Max Product 1: " + solution.maxProduct(nums1)); // 6
        System.out.println("Max Product 2: " + solution.maxProduct(nums2)); // 0
        System.out.println("Max Product 3: " + solution.maxProduct(nums3)); // 24
    }
}