/*
Problem: Second Largest Element in Array

Description:
Given an integer array nums, return the second largest distinct element.
If no such element exists, return -1.

Approach: Single Pass (Greedy)

Time Complexity: O(n)
Space Complexity: O(1)

Key Idea:
- Maintain two variables:
max1 → largest element
max2 → second largest element
- Update both while iterating through the array
- Ensure max2 always stores the largest value smaller than max1

Notes:
- Handles duplicates correctly (distinct second largest required)
- Returns -1 if second largest does not exist
*/

class SecondLargestElementInArray {
    public int secondLargestElement(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i : nums){
            if(i > max1){
                max2 = max1;
                max1 = i;
            }
            else if(i > max2 && i < max1){
                max2 = i;
            }
        }

        if(max2 == Integer.MIN_VALUE)
            return -1;

        return max2;
    }

    public static void main(String[] args){
        SecondLargestElementInArray sol = new SecondLargestElementInArray();

        int[] nums = {9, 5, 8, 10, 3};

        int result = sol.secondLargestElement(nums);

        System.out.println(result); // Output: 9
    }
}