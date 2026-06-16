/*
    Problem: Find the Duplicate Number

    Description:
    Given an array containing n+1 integers where each
    integer is in the range [1, n], exactly one number
    appears more than once. Find the duplicate number
    without modifying the array.

    Approach: Floyd's Cycle Detection (Tortoise & Hare)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Treat nums[i] as a pointer to the next index.
    - Since one number is duplicated, two indices point
      to the same value, creating a cycle.
    - Use slow and fast pointers to find a meeting point
      inside the cycle.
    - Reset one pointer to the start and move both one
      step at a time.
    - The point where they meet again is the duplicate.

    Alternative Approaches:

    1. HashSet
       - Store seen elements.
       - First repeated element is the answer.
       - Time: O(n)
       - Space: O(n)
       
    Notes:
    - Floyd's algorithm is the optimal solution because
      it uses constant extra space and does not modify
      the input array.
*/


public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // Your code goes here
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        fast = 0;

        do{
            slow = nums[slow];
            fast = nums[fast];
        } while(slow != fast);

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4 ,2 ,2};
        System.out.println(findDuplicate(nums));
    }
}
