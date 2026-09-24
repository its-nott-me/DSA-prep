/*
    Problem: Partition Array With Minimum Difference

    Description:
    Given an integer array nums of 2 * n integers, partition nums into
    two arrays of exactly n elements each.

    Return the minimum possible absolute difference between the sums
    of the two arrays.

    Example:
    nums = [3, 9, 7, 3]

    Possible partition:
    [3, 9] and [7, 3]

    Sum difference:
    |12 - 10| = 2

    Approach: Meet in the Middle + Binary Search

    Time Complexity:
    O(2^(n/2) * log(2^(n/2)))

    Space Complexity:
    O(2^(n/2))

    Key Idea:
    - Since nums contains 2 * n elements, split it into two halves.
    - Generate all possible subset sums for both halves.
    - While generating subsets, also store the number of elements
      used to create each sum.

    - leftSet[k] contains all subset sums formed by choosing exactly
      k elements from the left half.

    - rightSet[k] contains all subset sums formed by choosing exactly
      k elements from the right half.

    - If we choose i elements from the left half, we must choose
      (n - i) elements from the right half.

          i + (n - i) = n

      This guarantees that the selected partition contains exactly
      n elements.

    - Let selectedSum = leftSum + rightSum.

      The other partition has sum:

          total - selectedSum

      Therefore, the difference is:

          |selectedSum - (total - selectedSum)|

      = |2 * selectedSum - total|

    - We want selectedSum to be as close as possible to total / 2.

    - For every leftSum, calculate the ideal rightSum:

          rightSum ≈ total / 2 - leftSum

    - Sort the corresponding rightSet and use binary search to find
      the closest possible rightSum.

    - binarySearch returns:
        * index >= 0 if the target exists
        * -(insertionPoint) - 1 if the target does not exist

      Therefore, when the target is not found:

          pos = -pos - 1

      gives us the insertion position.

    - We check:
        * right.get(pos)
        * right.get(pos - 1)

      because the closest value to the target can be on either side
      of the insertion position.

    Why Meet in the Middle?
    - A normal sum-based DP would require memory proportional to the
      total possible sum, which can be extremely large.
    - Splitting the array into two halves reduces the number of
      subsets to:

          2^(n/2)

      For n = 15:

          2^15 = 32768

      which is manageable.

    Notes:
    - The order of elements does not matter.
    - Each subset represents one possible group of elements.
    - The two groups always contain exactly n elements each.
*/

import java.util.*;

public class PartitionArrayWithMinimumDifference {

    public void generateSubsets(
            List<Integer>[] sets,
            int[] arr,
            int idx,
            int sum,
            int count,
            int size
    ) {

        if (idx == size) {
            sets[count].add(sum);
            return;
        }

        // Take current element
        generateSubsets(
            sets,
            arr,
            idx + 1,
            sum + arr[idx],
            count + 1,
            size
        );

        // Don't take current element
        generateSubsets(
            sets,
            arr,
            idx + 1,
            sum,
            count,
            size
        );
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;

        if (n % 2 != 0) {
            return -1;
        }

        int half = n / 2;
        int total = Arrays.stream(nums).sum();

        int[] leftArr = Arrays.copyOfRange(nums, 0, half);
        int[] rightArr = Arrays.copyOfRange(nums, half, n);

        List<Integer>[] leftSet = new ArrayList[half + 1];
        List<Integer>[] rightSet = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            leftSet[i] = new ArrayList<>();
            rightSet[i] = new ArrayList<>();
        }

        // Generate all subset sums of both halves
        generateSubsets(
            leftSet,
            leftArr,
            0,
            0,
            0,
            half
        );

        generateSubsets(
            rightSet,
            rightArr,
            0,
            0,
            0,
            half
        );

        int minDifference = Integer.MAX_VALUE;

        /*
            If we select i elements from the left half,
            we need (half - i) elements from the right half.
        */
        for (int i = 0; i <= half; i++) {

            List<Integer> right = rightSet[half - i];

            // Sort so that binary search can be used
            Collections.sort(right);

            for (int l : leftSet[i]) {

                /*
                    We want:

                        l + r ≈ total / 2

                    Therefore:

                        r ≈ total / 2 - l
                */
                int target = total / 2 - l;

                int pos = Collections.binarySearch(right, target);

                /*
                    If target is not found, binarySearch returns:

                        -(insertionPoint) - 1

                    Recover the insertion point.
                */
                if (pos < 0) {
                    pos = -pos - 1;
                }

                /*
                    Check the first element >= target.
                */
                if (pos < right.size()) {

                    int r = right.get(pos);

                    minDifference = Math.min(
                        minDifference,
                        Math.abs(total - 2 * (l + r))
                    );
                }

                /*
                    Check the element immediately before target.

                    It may be closer to the target than right.get(pos).
                */
                if (pos > 0) {

                    int r = right.get(pos - 1);

                    minDifference = Math.min(
                        minDifference,
                        Math.abs(total - 2 * (l + r))
                    );
                }
            }
        }

        return minDifference;
    }

    public static void main(String[] args) {

        PartitionArrayWithMinimumDifference solution =
            new PartitionArrayWithMinimumDifference();

        int[] nums1 = {3, 9, 7, 3};

        System.out.println(
            "Minimum Difference : "
            + solution.minimumDifference(nums1)
        );
        // 2
        //
        // One optimal partition:
        // [3, 9] and [7, 3]
        //
        // |12 - 10| = 2


        int[] nums2 = {-36, 36};

        System.out.println(
            "Minimum Difference : "
            + solution.minimumDifference(nums2)
        );
        // 72


        int[] nums3 = {2, -1, 0, 4, -2, -9};

        System.out.println(
            "Minimum Difference : "
            + solution.minimumDifference(nums3)
        );
        // 0


        int[] nums4 = {1, 2, 3, 4};

        System.out.println(
            "Minimum Difference : "
            + solution.minimumDifference(nums4)
        );
        // 0
        //
        // [1, 4] and [2, 3]
        // |5 - 5| = 0
    }
}