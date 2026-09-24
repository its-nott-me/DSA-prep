/*
    Problem: House Robber I

    You are given an array nums[] where:
        nums[i] = amount of money in house i.

    The houses are arranged in a straight line.

    The robber cannot rob two adjacent houses.

    Find the maximum amount of money the robber can steal.

    Example:

        nums = {2, 7, 9, 3, 1}

        Optimal choice:
            Rob house 0 -> 2
            Rob house 2 -> 9
            Rob house 4 -> 1

        Total = 2 + 9 + 1 = 12


    Approach: Dynamic Programming

    DP State:

    dp[i] = maximum amount of money that can be robbed
            from the first i houses.

    At every house, we have two choices:

    1. Don't rob the current house:
            dp[i - 1]

    2. Rob the current house:
            dp[i - 2] + nums[i - 1]

       We add nums[i-1] to dp[i-2] because
       the previous house cannot be robbed.


    Transition:

        dp[i] = max(
            dp[i - 1],
            dp[i - 2] + nums[i - 1]
        )


    Base Case:

        dp[0] = 0

        No houses -> no money.

        dp[1] = nums[0]

        Only one house -> rob that house.


    Answer:

        dp[n]

        This represents the maximum money that can be
        robbed from all n houses.


    Time Complexity:
        O(n)

    Space Complexity:
        O(n)
*/

public class HouseRobberI {

    public static int rob(int[] nums) {
        int n = nums.length;

        // dp[i] = maximum money that can be robbed
        // from the first i houses
        int[] dp = new int[n + 1];

        // Base case:
        // If there is only one house,
        // rob that house
        dp[1] = nums[0];

        // Process houses from 2nd house onwards
        for(int i = 2; i <= n; i++){

            // Two choices:
            //
            // 1. Don't rob current house:
            //      dp[i - 1]
            //
            // 2. Rob current house:
            //      dp[i - 2] + nums[i - 1]
            //
            // Choose the maximum of both
            dp[i] = Math.max(
                dp[i - 2] + nums[i - 1],
                dp[i - 1]
            );
        }

        // Maximum money that can be robbed
        return dp[n];
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(
            "Maximum Money: " +
            rob(nums)
        ); // 12


        int[] nums2 = {2, 1, 1, 2};

        System.out.println(
            "Maximum Money: " +
            rob(nums2)
        ); // 4
    }
}
