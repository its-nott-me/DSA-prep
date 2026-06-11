/*
    Problem: Sort Colors (Dutch National Flag Problem)

    Description:
    Given an array nums with n objects colored red (0), white (1), and blue (2),
    sort them in-place so that objects of the same color are adjacent,
    in the order 0 → 1 → 2.

    Approach: Three Pointers (Dutch National Flag Algorithm)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Maintain three regions:
        [0 ... low-1]     → 0s
        [low ... i-1]     → 1s
        [i ... high]      → unknown
        [high+1 ... end]  → 2s
    - Traverse using pointer i
        - If nums[i] == 0 → swap with low, move both i and low
        - If nums[i] == 2 → swap with high, move high only
        - If nums[i] == 1 → just move i

    Notes:
    - Do NOT increment i when swapping with high (important)
    - In-place sorting without extra space
*/

class SortColors {
    public static void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors(int[] nums) {
        int i = 0, low = 0, high = nums.length - 1;

        while(i <= high){
            if(nums[i] == 2){
                swap(i, high, nums);
                high--;
            } 
            else if(nums[i] == 0){
                swap(i, low, nums);
                low++;
                i++;
            } 
            else {
                i++;
            }
        }
    }

    public static void main(String[] args){
        SortColors sol = new SortColors();

        int[] nums = {2, 0, 2, 1, 1, 0};

        sol.sortColors(nums);

        for(int x : nums){
            System.out.print(x + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}