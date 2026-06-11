/*
    Problem: Longest Subarray with Sum K

    Description:
    Given an integer array nums and an integer k, return the length of the
    longest subarray whose sum equals k.

    Approach: Prefix Sum + HashMap

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Use prefix sum to store cumulative sum up to each index
    - If (current sum - k) exists in map, it means a subarray with sum k exists
    - Length of that subarray = current index - index of (sum - k)
    - Store first occurrence of each prefix sum for maximum length

    Notes:
    - map stores (prefixSum → first index)
    - Initialize map with (0 → -1) to handle subarrays starting from index 0
    - Works for negative numbers as well (unlike sliding window)
*/

import java.util.*;

class LongestSubarrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, max = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }

            // store first occurrence only
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args){
        LongestSubarrayWithSumK sol = new LongestSubarrayWithSumK();

        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        int result = sol.longestSubarray(nums, k);

        System.out.println(result); // Output: 4
    }
}