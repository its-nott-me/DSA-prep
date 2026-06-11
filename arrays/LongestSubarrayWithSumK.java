/*
    Problem: Longest Subarray with Sum K

    Description:
    Given an integer array nums and an integer k, return the length of the
    longest subarray whose sum equals k. If no such subarray exists, return 0.

    Approach: Prefix Sum + HashMap

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Use a running prefix sum while traversing the array
    - If (current_sum - k) exists in the map, a subarray with sum k is found
    - Store the first occurrence of each prefix sum to maximize subarray length
    - Initialize map with (0 → -1) to handle subarrays starting from index 0

    Notes:
    - Works with both positive and negative numbers
    - Do NOT overwrite prefix sum indices (store only first occurrence)
*/

import java.util.*;

class LongestSubarrayWithSumK {

    public int longestSubarray(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 at index -1
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        LongestSubarrayWithSumK sol = new LongestSubarrayWithSumK();

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int result = sol.longestSubarray(nums, k);

        System.out.println(result); // Output: 4
    }
}