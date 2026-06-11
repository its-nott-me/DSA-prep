/*
    Problem: Majority Element

    Description:
    Given an array nums of size n, return the element that appears more than n/2 times.
    It is guaranteed that such an element always exists.

    Approach: Boyer–Moore Majority Vote Algorithm

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Maintain a candidate and a counter
    - If current element matches candidate → increase count
    - If count becomes 0 → choose new candidate
    - Otherwise → decrease count
    - Majority element survives because it appears more than all others combined

    Notes:
    - Works only when majority element is guaranteed to exist
    - No extra space required (optimal solution)
*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        int current_candidate = nums[0], count = 0;

        // Boyer–Moore Majority Vote Algorithm
        for(int x : nums){
            if(x == current_candidate) {
                count++;
            } 
            else if(count == 0) {
                current_candidate = x;
                count++;
            } 
            else {
                count--;
            }
        }

        return current_candidate;
    }

    public static void main(String[] args){
        MajorityElement sol = new MajorityElement();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(sol.majorityElement(nums)); // Output: 2
    }
}