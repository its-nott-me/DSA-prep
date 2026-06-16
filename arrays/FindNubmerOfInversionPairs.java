/*
    Problem: Count Inversions in an Array

    Description:
    An inversion is a pair (i, j) such that:
        i < j and nums[i] > nums[j]

    Approach: Merge Sort

    Time Complexity: O(n log n)
    Space Complexity: O(n)

    Key Idea:
    - Recursively sort the left and right halves
    - Count inversions during the merge step
    - If nums[left] > nums[right], then all elements from
      left to mid form inversions with nums[right]

        inversions += (mid - left + 1)

    Alternative Idea:
    - Use a stack while traversing the array and pop larger
      previously seen elements (similar to Daily Temperatures)
    - However, this can still take O(n²) in the worst case
      (e.g., descending array)
    - Merge sort guarantees O(n log n) for all inputs

    Notes:
    - Use long for the inversion count
    - The array gets sorted as a byproduct
*/


import java.util.*;

public class FindNubmerOfInversionPairs {
    public static long merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        long inversions = 0;

        while(left <= mid && right <= high){
            if(nums[left] > nums[right]){
                temp.add(nums[right++]);

                inversions += (mid-left+1);
            } else {
                temp.add(nums[left++]);
            }
        }

        while(left <= mid){
            temp.add(nums[left++]);
        }

        while(right <= high){
            temp.add(nums[right++]);
        }

        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i-low);
        }

        return inversions;
    }

    public static long sort(int[] nums, int low, int high){
        if(low >= high) return 0;

        int mid = low + (high-low)/2;

        long count = 0;

        count += sort(nums, low, mid);
        count += sort(nums, mid+1, high);
        count += merge(nums, low, mid, high);

        return count;
    }

    public static long numberOfInversions(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1 , 5};

        System.out.println(numberOfInversions(nums));
    }
}