/*
    Problem: Find Missing and Repeating Number

    Description:
    Given an array containing numbers from 1 to n,
    one number is missing and one number appears twice.
    Find both numbers.

    Approach: Mathematical Formulas

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    Maintain:
    - actualSum = 1 + 2 + ... + n
    - calcSum = sum of array elements
    - actualSumOfSquares = 1² + 2² + ... + n²
    - calcSumOfSquares = sum of squares of array elements

    Let:
    - m = missing number
    - r = repeating number

    Then:
    - m - r = actualSum - calcSum
    - m² - r² = actualSumOfSquares - calcSumOfSquares

    Solving these equations gives both numbers.

    Invariant:
    - actualSum and actualSumOfSquares always represent
      the expected values for numbers 1..n.

    Alternative Approaches:

    1. Brute Force (HashSet)
       - Store seen elements in a set
       - Duplicate gives the repeating number
       - missing = (actualSum - calcSum) + repeating
       - Time: O(n)
       - Space: O(n)

    2. Cycle Sort
       - Place each value x at index x-1
       - After rearrangement, the mismatched index reveals
         the missing and repeating numbers
       - Time: O(n)
       - Space: O(1)
       - Tradeoff: Mutates the input array

    Notes:
    - Use long to avoid overflow while computing sums
      and sums of squares.
*/

import java.util.Arrays;

public class FindMissingAndReapeatedNumber {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        long actualSum = 0;
        long calcSum = 0;
        long actualSumOfSquares = 0;
        long calcSumOfSquares = 0;

        for(int i = 1; i <= n; i++){
            int num = nums[i-1];

            actualSum += i;
            calcSum += num;

            actualSumOfSquares += 1L*i*i;
            calcSumOfSquares += 1L*num*num;
        }

        long d = actualSum - calcSum;
        long dSquare = actualSumOfSquares - calcSumOfSquares;

        long sum = (dSquare/d);

        long missing = (sum + d)/2;
        long repeating = sum - missing;

        return new int[] {(int)repeating, (int)missing};
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 4, 5};
        int[] res = findMissingRepeatingNumbers(nums);

        System.out.println(Arrays.toString(res));
    }
}
