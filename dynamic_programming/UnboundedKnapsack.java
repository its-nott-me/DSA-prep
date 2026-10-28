/*
    Problem: Unbounded Knapsack

    Goal:
    Maximize the total value of items without exceeding capacity W.

    Rule:
    Each item can be chosen unlimited times.

    DP meaning:
    prev[j] = maximum value achievable with capacity j
              using previously processed items.

    next[j] = maximum value achievable with capacity j
              using items processed so far, including the current item.

    Idea:
    For each item, decide whether to take it or skip it.

    Transitions:
    - If current item is too heavy:
        next[j] = prev[j]

    - Otherwise:
        next[j] = max(
            skip item → prev[j],
            take item → next[j - wt[i]] + val[i]
        )

    Note:
    We use next[j - wt[i]] instead of prev[j - wt[i]]
    because the current item can be chosen multiple times.

    Initialization:
    prev[j] = 0 for all j initially, since no items are processed.
    Capacity 0 always has value 0.

    Answer: prev[W]

    Time: O(n * W)
    Space: O(W)
*/

import java.util.*;

public class UnboundedKnapsack {

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        int[] next = new int[W + 1];

        for (int i = 0; i < n; i++) {
            int currWeight = wt[i];
            int currVal = val[i];

            for (int j = 1; j <= W; j++) {
                if (j < currWeight) {
                    next[j] = prev[j];
                } else {
                    next[j] = Math.max(
                        prev[j],
                        next[j - currWeight] + currVal
                    );
                }
            }

            prev = Arrays.copyOf(next, W + 1);
        }

        return prev[W];
    }

    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;

        UnboundedKnapsack solution = new UnboundedKnapsack();

        System.out.println(
            "Maximum Knapsack Value: " +
            solution.unboundedKnapsack(wt, val, n, W)
        ); // Output: 27
    }
}