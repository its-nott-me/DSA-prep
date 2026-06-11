/*
    Problem: Minimum Number of Days to Make m Bouquets

    Description:
    You are given an array bloomDay where bloomDay[i] is the day the i-th flower blooms.
    You need to make m bouquets, each bouquet requiring k adjacent flowers.
    Return the minimum number of days needed to make m bouquets.
    If not possible, return -1.

    Approach: Binary Search on Answer + Greedy Check

    Time Complexity: O(n log(max(bloomDay)))
    Space Complexity: O(1)

    Key Idea:
    - We binary search on "day"
    - For a given day, check if we can form at least m bouquets:
        - Count consecutive bloomed flowers (bloomDay[i] <= day)
        - When we reach k consecutive flowers → form a bouquet
    - If possible → try smaller days
    - If not → increase days

    Notes:
    - Important feasibility check using greedy scan
    - Early return when m bouquets are formed
    - Also check impossible case: m * k > n
*/

class MinimumDaysToMakeMBouquets {

    public static boolean isBouquetsPossible(int[] arr, int bouquets, int flowers, int day){
        int bCount = 0, fCount = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                fCount++;

                if(fCount == flowers){
                    bCount++;
                    fCount = 0;

                    if(bCount == bouquets)
                        return true;
                }
            } else {
                fCount = 0;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m * k > bloomDay.length) return -1;

        int start = Integer.MAX_VALUE, end = 0;

        for(int x : bloomDay){
            start = Math.min(start, x);
            end = Math.max(end, x);
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isBouquetsPossible(bloomDay, m, k, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args){
        MinimumDaysToMakeMBouquets sol = new MinimumDaysToMakeMBouquets();

        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        System.out.println(sol.minDays(bloomDay, m, k)); // Output: 3
    }
}