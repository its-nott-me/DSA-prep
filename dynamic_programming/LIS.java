/*
    Problem: Longest Increasing Subsequence (LIS)

    Description:
    Given an integer array nums, return the length of the longest strictly
    increasing subsequence.

    A subsequence is a sequence that can be derived from an array by deleting
    some or no elements without changing the order of the remaining elements.

    Approach: Patience Sorting + Binary Search

    Time Complexity: O(n log n)
    Space Complexity: O(n)

    Key Idea:
    - Maintain a list called 'tails' where tails[i] stores the smallest
      possible tail value of an increasing subsequence of length (i + 1).
    - For each number:
        1. If it is greater than the last element in tails,
           extend the subsequence by adding it.
        2. Otherwise, use binary search to find the first element in tails
           that is greater than or equal to the current number and replace it.
    - Replacing elements does not change the length of an existing subsequence,
      but creates a better opportunity to build longer subsequences later.

    Notes:
    - The tails array does NOT represent the actual LIS.
    - The size of tails at the end equals the length of the LIS.
    - Binary search is used to efficiently find the replacement position.
*/


import java.util.*;

public class LIS {
    public static int binarySearch(ArrayList<Integer> nums, int target){
        int high = nums.size() - 1;
        int low = 0;
        
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums.get(mid) == target){
                return mid;
            } else if(nums.get(mid) > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public static int getLIS(int[] nums) {
        // ============== DP approach ===============

        // int n = nums.length;
        // int[] dp = new int[n];

        // for(int i = 0; i < n; i++){
        //     int maxLength = 0;
        //     for(int j = i-1; j >= 0; j--){
        //         if(nums[j] < nums[i] && maxLength < dp[j]){
        //             maxLength = dp[j];
        //         }
        //     }

        //     dp[i] = maxLength + 1;
        // }

        // int res = 0;

        // for(int i : dp){
        //     res = Math.max(res, i);
        // }

        // return res;


        // =============== Patience sort + BS ===============
        int n = nums.length;
        ArrayList<Integer> tails = new ArrayList<>();

        tails.add(nums[0]);

        for(int i = 1; i < n; i++){
            int num = nums[i];
            int size = tails.size();

            if(tails.get(size-1) < num){
                tails.add(num);
            } else {
                int idx = binarySearch(tails, num);

                tails.set(idx, num);
            }
        }

        return tails.size();
    }

    public static void main(String[] args) {

      int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
      int[] nums2 = {0, 1, 0, 3, 2, 3};
      int[] nums3 = {7, 7, 7, 7, 7, 7};

      System.out.println("LIS Length 1: " + getLIS(nums1)); // 4
      System.out.println("LIS Length 2: " + getLIS(nums2)); // 4
      System.out.println("LIS Length 3: " + getLIS(nums3)); // 1
  }
}


