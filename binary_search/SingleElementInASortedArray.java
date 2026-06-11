/*
    Problem: Single Element in a Sorted Array

    Description:
    Given a sorted array where every element appears exactly twice except
    for one element which appears once, find the single element.

    Approach: Binary Search (Index Pairing Logic)

    Time Complexity: O(log n)
    Space Complexity: O(1)

    Key Idea:
    - In a properly paired array:
        (even index, odd index) → same elements
    - Before the single element, pairs are aligned correctly
    - After the single element, pairing shifts
    - So we force mid to be even and check its pair:
        - If nums[m] == nums[m+1] → single element is on right side
        - Else → single element is on left side (including m)

    Notes:
    - Uses index parity to eliminate half the search space
    - Efficient O(log n) solution instead of linear scan
*/

class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;

        if(nums.length == 1) return nums[0];

        while(s < e){
            int m = s + (e - s) / 2;

            // ensure m is even
            if(m % 2 == 1) m--;

            // check if pair is valid
            if(nums[m] == nums[m + 1]){
                s = m + 2; // single element is after this pair
            } else {
                e = m; // single element is before or at m
            }
        }

        return nums[s];
    }

    public static void main(String[] args){
        SingleElementInSortedArray sol = new SingleElementInSortedArray();

        int[] nums = {1, 1, 2, 3, 3, 4, 4};

        System.out.println(sol.singleNonDuplicate(nums)); // Output: 2
    }
}