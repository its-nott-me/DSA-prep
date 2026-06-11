/*
    Problem: Kth Missing Positive Number

    Description:
    Given a sorted array of positive integers arr, and an integer k,
    return the k-th missing positive number.

    Approach: Linear Scan Adjustment (Optimized Insight)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - We start assuming k is the answer in a perfect sequence [1, 2, 3, ...]
    - Traverse the array:
        - If arr[i] <= k, it means this number exists in the sequence
        - So we "push" k forward by 1
    - Final k will land on the missing number

    Why it works:
    - Every time we find a number ≤ k, it reduces the gap
    - Effectively shifts k to account for already existing numbers

    Notes:
    - This is a greedy shortcut of counting missing numbers
    - Binary search solution exists for O(log n)
*/

class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {

        for(int i : arr){
            if(i <= k)
                k++;   // shift k forward
            else
                break;
        }

        return k;
    }

    public static void main(String[] args){
        KthMissingPositiveNumber sol = new KthMissingPositiveNumber();

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println(sol.findKthPositive(arr, k)); // Output: 9
    }
}