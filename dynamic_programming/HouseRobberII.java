/*
    Problem: House Robber II

    You are given an array nums[] where:
        nums[i] = amount of money in house i.

    The houses are arranged in a circle.

    The robber cannot rob two adjacent houses.

    Since the houses are in a circle:
        - House 0 and House n-1 are also adjacent.
        - Therefore, we cannot rob both the first and last house.

    Find the maximum amount of money the robber can steal.

    Approach: Dynamic Programming

    Since the first and last houses are adjacent,
    we divide the problem into two cases:

    Case 1:
        Rob houses from 0 to n-2
        -> Exclude the last house.

    Case 2:
        Rob houses from 1 to n-1
        -> Exclude the first house.

    Solve both cases using the normal House Robber DP
    and take the maximum of the two results.

    DP State:

    dp[i] = maximum money that can be robbed from the
            considered houses up to index i.

    Transition:

    dp[i] = max(
        dp[i-1],              // Do not rob current house
        dp[i-2] + nums[i-1]   // Rob current house
    )

    Base Case:

    For Case 1:
        dp[1] = nums[0]

    For Case 2:
        dp[2] = nums[1]

    Answer:

        max(
            maximum money when first house is included,
            maximum money when first house is excluded
        )

    Edge Case:

        If there is only one house,
        we can simply rob that house.

    Time Complexity:
        O(n)

    Space Complexity:
        O(n)
*/

public class HouseRobberII {

    public static int rob(int[] nums) {
        int n = nums.length;

        // If there is only one house,
        // rob that house directly
        if(n == 1) return nums[0];

        /*
            Case 1:
            Consider houses from index 0 to n-2.

            We exclude the last house because
            the first house is considered.
        */

        int[] dp = new int[n + 1];

        // Base case:
        // Only the first house is considered
        dp[1] = nums[0];

        // Process houses from index 1 to n-2
        for(int i = 2; i <= n - 1; i++){

            // Current house is nums[i-1]
            dp[i] = Math.max(
                dp[i - 1],              // Don't rob current house
                dp[i - 2] + nums[i - 1] // Rob current house
            );
        }

        // Maximum money when first house is included
        // and last house is excluded
        int res = dp[n - 1];


        /*
            Case 2:
            Consider houses from index 1 to n-1.

            We exclude the first house because
            the last house is considered.
        */

        dp = new int[n + 1];

        // Base case:
        // Only the second house is considered
        dp[2] = nums[1];

        // Process houses from index 2 to n-1
        for(int i = 3; i <= n; i++){

            // Current house is nums[i-1]
            dp[i] = Math.max(
                dp[i - 1],              // Don't rob current house
                dp[i - 2] + nums[i - 1] // Rob current house
            );
        }

        // Return the better result from both cases
        return Math.max(res, dp[n]);
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};

        System.out.println(
            "Maximum Money: " +
            rob(nums)
        ); // 3


        int[] nums2 = {1, 2, 3, 1};

        System.out.println(
            "Maximum Money: " +
            rob(nums2)
        ); // 4
    }
}
