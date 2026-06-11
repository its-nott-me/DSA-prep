/*
    Problem: Binary subarray with sum
    Approach: Sliding window 
    Time: O(n)
    Space: O(1)
    Notes:
    - Use sliding window to count subarrays with sum less than equal to k
    - For each valid window, all subarrays ending at right are valid → add (right - left + 1)
    - Since array is binary (0/1), sliding window works correctly
    - subarrays with sum == k = atMost(k) - atMost(k-1)
*/

class BinarySubarraysWithSum {
    public static int atmost(int[] nums, int k){
        int n = nums.length;
        int left = 0, count = 0, sum = 0;

        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(left <= right && sum > k){
                sum -= nums[left];
                left++;
            }

            count += right-left+1;
        }

        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,1,0,1};
        int goal = 2;
        
        int res = numSubarraysWithSum(arr, goal);

        System.out.println(res);
    }
}