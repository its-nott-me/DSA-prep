/*
    Problem: Two Sum

    Description:
    Given an integer array nums and an integer target, return indices of the
    two numbers such that they add up to target.
    Assume exactly one solution exists and the same element cannot be used twice.

    Approach: HashMap

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Traverse the array once
    - For each element, compute complement = target - nums[i]
    - If complement exists in map, we found the pair
    - Otherwise, store current element with its index

    Notes:
    - map stores (value → index)
    - No need to check map.get(diff) != i since we insert after checking
*/

import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args){
        TwoSum sol = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = sol.twoSum(nums, target);

        System.out.println(res[0] + " " + res[1]); // Output: 0 1
    }
}