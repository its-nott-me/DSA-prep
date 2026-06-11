/*
    Problem: Rearrange Array Elements by Sign

    Description:
    Given an array nums of even length consisting of equal number of
    positive and negative integers, rearrange the array such that
    positive and negative numbers alternate, starting with a positive number.

    Approach: Extra Arrays (Two Lists Simulation)

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Separate positive and negative numbers into two arrays
    - Then merge them alternately into the result array
    - Maintain original relative order within positives and negatives

    Notes:
    - Assumes equal number of positive and negative elements
    - First element in result is always positive
*/

class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        for(int i = 0, j = 0, k = 0; i < nums.length; i++){
            if(nums[i] > 0) positive[j++] = nums[i];
            else negative[k++] = nums[i];
        }

        int[] result = new int[nums.length];

        for(int i = 0, j = 0, k = 0; i < nums.length; ){
            result[i++] = positive[j++];
            result[i++] = negative[k++];
        }

        return result;
    }

    public static void main(String[] args){
        RearrangeArrayElementsBySign sol = new RearrangeArrayElementsBySign();

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] res = sol.rearrangeArray(nums);

        for(int x : res){
            System.out.print(x + " ");
        }
        // Output: 3 -2 1 -5 2 -4
    }
}