/*
    Problem: Koko Eating Bananas

    Description:
    Given an array piles where piles[i] is the number of bananas in the ith pile
    and an integer h representing hours, find the minimum eating speed k such that
    Koko can eat all bananas within h hours.

    Approach: Binary Search on Answer

    Time Complexity: O(n log max(piles))
    Space Complexity: O(1)

    Key Idea:
    - Koko's eating speed k determines total time required
    - If k is small → takes too long
    - If k is large → finishes faster
    - Use binary search on possible values of k (1 to max pile size)
    - For each k, compute total hours needed using ceil division:
        time += (pile + k - 1) / k

    Notes:
    - This is not a classic binary search on array, but on answer space
    - Greedy feasibility check inside binary search
*/

class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = 0;

        // find maximum pile (upper bound of k)
        for(int pile : piles)
            e = Math.max(e, pile);

        while(s <= e){
            int m = s + (e - s) / 2;

            long timeTaken = 0;

            // calculate hours needed at speed m
            for(int x : piles){
                timeTaken += (x + m - 1) / m; // ceil(x / m)
                if(timeTaken > h) break; // early exit optimization
            }

            if(timeTaken > h){
                s = m + 1; // speed too slow
            } else {
                e = m - 1; // try smaller speed
            }
        }

        return s;
    }

    public static void main(String[] args){
        KokoEatingBananas sol = new KokoEatingBananas();

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(sol.minEatingSpeed(piles, h)); // Output: 4
    }
}