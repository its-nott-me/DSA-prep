import java.util.*;

public class CountPartitionsWithGivenDifference {

    public int countPartitions(int n, int diff, int[] arr) {

        final int MOD = 1_000_000_007;

        // Calculate the total sum of all array elements.
        int sum = Arrays.stream(arr).sum();

        // If the difference is greater than the total sum,
        // no valid partition is possible.
        if (diff > sum) {
            return 0;
        }

        // Let sum1 and sum2 be the sums of the two partitions.
        //
        // sum1 + sum2 = sum
        // sum1 - sum2 = diff
        //
        // Adding both equations:
        // 2 * sum1 = sum + diff
        //
        // Therefore:
        // sum1 = (sum + diff) / 2
        //
        // We need to count subsets whose sum equals target.
        if ((sum + diff) % 2 != 0) {
            return 0;
        }

        int target = (sum + diff) / 2;

        // dp[s] stores the number of subsets whose sum is s.
        long[] dp = new long[target + 1];

        // Base case:
        // There is exactly one way to obtain sum 0:
        // choose no elements.
        dp[0] = 1L;

        // Process each array element to calculate
        // the number of subsets for every possible sum.
        for (int num : arr) {

            // Traverse backwards to ensure each element
            // is used at most once.
            for (int s = target; s >= num; s--) {

                // Include the current element in subsets
                // that previously had sum (s - num).
                dp[s] = (dp[s] + dp[s - num]) % MOD;
            }
        }

        // The number of subsets with the required sum
        // equals the number of valid partitions.
        return (int) dp[target];
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int diff = 3;

        CountPartitionsWithGivenDifference solution =
            new CountPartitionsWithGivenDifference();

        System.out.println(
            "Number of Partitions: "
            + solution.countPartitions(n, diff, arr)
        );

        // Output: Number of Partitions: 1
    }
}