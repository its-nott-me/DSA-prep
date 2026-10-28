/*
    Problem: Target Sum

    Given an array nums[] of integers and an integer target,
    assign either a '+' or '-' sign to each element.

    Find the total number of ways to assign signs such that
    the sum of all elements equals the target.

    Example:
        nums = {1, 1, 1, 1, 1}
        target = 3

    Output:
        5

    Approach: Dynamic Programming (Subset Sum)

    Let:
        P = sum of elements assigned a '+' sign
        N = sum of elements assigned a '-' sign (absolute values)
        sum = total sum of all elements

    Equations:
        P - N = target
        P + N = sum

    Therefore:
        N = (sum - target) / 2

    The problem becomes counting subsets whose sum equals:
        subsetSum = (sum - target) / 2

    If |target| > sum, the target is impossible to achieve.

    If (sum - target) is odd, no valid subset sum exists.

    dp[i] = number of subsets whose sum equals i

    Base Case:
        dp[0] = 1

        There is one way to form sum 0: choose no elements.

    Transition:
        dp[i] = dp[i] + dp[i - num]

        dp[i] represents subsets that exclude the current number.
        dp[i - num] represents subsets that include the current number.

    Iterate backwards to ensure each element is used only once.

    Answer:
        dp[subsetSum]

    Time Complexity: O(n * subsetSum)
    Space Complexity: O(subsetSum)
*/

import java.util.*;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        // If the target exceeds the total possible sum,
        // no assignment of '+' and '-' signs can achieve it.
        if (Math.abs(target) > sum) return 0;

        // Convert Target Sum into a subset sum problem.
        int subsetSum = sum - target;

        // The subset sum must be an integer.
        if (subsetSum % 2 != 0) return 0;

        subsetSum /= 2;

        // dp[i] stores the number of subsets with sum i.
        int[] dp = new int[subsetSum + 1];

        // One way to form sum 0: select no elements.
        dp[0] = 1;

        // Process each number exactly once.
        for (int num : nums) {

            // Iterate backwards to avoid using the same
            // element more than once.
            for (int i = subsetSum; i >= num; i--) {

                // Count subsets that include the current number
                // in addition to subsets that exclude it.
                dp[i] += dp[i - num];
            }
        }

        // Return the number of subsets that form subsetSum.
        return dp[subsetSum];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(
            "Number of Ways: " +
            findTargetSumWays(nums, target)
        ); // 5
    }
}