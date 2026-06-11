/*
    Problem: CountNumberofNiceSubarrays
    Description: Given an array of integers nums and an integer k. 
    A continuous subarray is called nice if there are k odd numbers on it.
    Return the number of nice sub-arrays.
    Approach: Sliding window 
    Time: O(n)
    Space: O(1)
    Notes:
    - Use a sliding window to count subarrays with with less than or equal to k odd numbers
    - this is similar to binary array as we can consider odd number --> 1, even number --> 0
    - for each valid window, all subarrays ending at right are valid so add (right-left+1)
    - subarrays with k odd numbers = atmost(k) - atmost(k-1)
*/

class CountNumberofNiceSubarrays {
    public static int atmost(int[] nums, int k){
        int left = 0, count = 0;
        int n = nums.length, sum = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] % 2 != 0) sum++;

            while(left <= right && sum > k){
                if(nums[left] % 2 != 0) sum--;
                left++;
            }

            count += right-left+1;
        }

        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,1,1};
        int k = 3;
        
        int res = numberOfSubarrays(arr, k);
        System.out.println(res);
    }
}