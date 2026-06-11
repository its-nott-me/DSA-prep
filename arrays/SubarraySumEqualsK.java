/*
    Problem: Subarray Sum Equals K

    Description:
    Given an integer array nums and an integer k, return the total number
    of continuous subarrays whose sum equals k.

    Approach: Prefix Sum + HashMap

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Maintain a running prefix sum
    - If (current sum - k) exists in map, it means a subarray with sum k ends here
    - Add the frequency of (sum - k) to count
    - Store frequency of each prefix sum in map

    Notes:
    - map stores (prefixSum → frequency)
    - Initialize map with (0 → 1) to handle subarrays starting from index 0
    - Works with negative numbers as well
*/

import java.util.*;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0, count = 0;

        for(int x : nums){
            sum += x;

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args){
        SubarraySumEqualsK sol = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(sol.subarraySum(nums, k)); // Output: 2
    }
}