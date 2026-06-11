/*
    Problem: Split Array Largest Sum

    Description:
    Given an array nums and an integer k, split the array into k non-empty
    continuous subarrays such that the largest sum among these subarrays is minimized.
    Return that minimized largest sum.

    Approach: Binary Search on Answer + Greedy Check

    Time Complexity: O(n log(sum(nums)))
    Space Complexity: O(1)

    Key Idea:
    - We binary search on the possible answer (maximum subarray sum)
    - Lower bound = max element (must include largest single value)
    - Upper bound = sum of all elements (one big subarray)
    - For a candidate max sum (m):
        - Greedily split array into subarrays
        - If required splits > k → m is too small
        - Else → m is valid, try smaller

    Notes:
    - Greedy works because we always extend subarray until limit is exceeded
    - Classic partition + binary search on answer pattern
*/

class SplitArrayLargestSum {

    public static boolean canSplit(int[] nums, int k, int m){
        int count = 1;
        int sum = 0;

        for(int x : nums){
            if(sum + x > m){
                count++;
                sum = x;

                if(count > k)
                    return false;
            } else {
                sum += x;
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        int s = 0, e = 0;

        for(int x : nums){
            s = Math.max(s, x); // lower bound
            e += x;             // upper bound
        }

        int ans = e;

        while(s <= e){
            int m = s + (e - s) / 2;

            if(canSplit(nums, k, m)){
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        SplitArrayLargestSum sol = new SplitArrayLargestSum();

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        System.out.println(sol.splitArray(nums, k)); // Output: 18
    }
}