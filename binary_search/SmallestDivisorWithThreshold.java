/*
    Problem: Find the Smallest Divisor Given a Threshold

    Description:
    You are given an array nums and an integer threshold.
    You choose a divisor d, and each number nums[i] contributes ceil(nums[i] / d).
    Return the smallest divisor such that the sum of these values is <= threshold.

    Approach: Binary Search on Answer + Greedy Check

    Time Complexity: O(n log max(nums))
    Space Complexity: O(1)

    Key Idea:
    - We binary search on possible divisor values (1 to max element)
    - For a given divisor m:
        - Compute total sum of ceil(nums[i] / m)
        - If sum > threshold → divisor too small
        - Else → try smaller divisor

    Notes:
    - This is a classic "binary search on answer" problem
    - Ceil division is used to simulate rounding up consumption
*/

class SmallestDivisorWithThreshold {

    public static boolean exceedsThreshold(int[] nums, int m, int t){
        int res = 0;

        for(int x : nums)
            res += (x + m - 1) / m; // ceil(x / m)

        return res > t;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = 0;

        for(int x : nums)
            end = Math.max(end, x);

        while(start < end){
            int mid = start + (end - start) / 2;

            if(exceedsThreshold(nums, mid, threshold)){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static void main(String[] args){
        SmallestDivisorWithThreshold sol = new SmallestDivisorWithThreshold();

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(sol.smallestDivisor(nums, threshold)); // Output: 5
    }
}