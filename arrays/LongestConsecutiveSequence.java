/*
    Problem: Longest Consecutive Sequence

    Description:
    Given an unsorted array of integers nums, return the length of the
    longest consecutive elements sequence. The sequence must be consecutive
    numbers in any order (not necessarily contiguous in array).

    Approach: HashSet + Sequence Start Check

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Insert all elements into a HashSet for O(1) lookup
    - Only start counting from elements that are the beginning of a sequence
      (i.e., x-1 is not present)
    - From each start, extend the sequence forward (x+1, x+2, ...)
    - Track the maximum length found

    Notes:
    - Ensures each sequence is processed only once
    - Avoids sorting, achieving optimal linear time
*/

import java.util.*;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int x : nums)
            set.add(x);

        // edge case: 0 or 1 unique elements
        if(set.size() < 2){
            return set.size();
        }

        for(int x : set){
            // only start from sequence beginning
            if(!set.contains(x - 1)){
                int currentCount = 0;
                int curr = x;

                while(set.contains(curr)){
                    currentCount++;
                    curr++;
                }

                max = Math.max(max, currentCount);
            }
        }

        return max;
    }

    public static void main(String[] args){
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(sol.longestConsecutive(nums)); // Output: 4
    }
}