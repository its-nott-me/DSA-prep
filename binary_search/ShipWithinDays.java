/*
    Problem: Capacity To Ship Packages Within D Days

    Description:
    You are given weights of packages and a number of days.
    You need to ship all packages in order within D days.
    Each day you can ship at most 'capacity' weight.
    Return the minimum capacity required.

    Approach: Binary Search on Answer + Greedy Simulation

    Time Complexity: O(n log(sum(weights)))
    Space Complexity: O(1)

    Key Idea:
    - Binary search on possible ship capacity:
        start = max(weights) (minimum possible capacity)
        end = sum(weights) (maximum possible capacity)
    - For a given capacity (mid):
        - Simulate shipping day by day
        - If weight exceeds capacity → move to next day
    - If we can ship within given days → try smaller capacity
    - Otherwise → increase capacity

    Notes:
    - Greedy works because we always pack as much as possible per day
    - Order of weights must be preserved
*/

class ShipWithinDays {

    public static boolean possibleToShip(int[] weights, int days, int cap){
        int curr = 0;
        int neededDays = 1;

        for(int w : weights){
            if(w > cap) return false;

            if(curr + w > cap){
                neededDays++;
                curr = 0;
            }

            curr += w;
        }

        return neededDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;

        for(int x : weights){
            start = Math.max(start, x); // max single weight
            end += x;                  // total weight
        }

        while(start < end){
            int mid = start + (end - start) / 2;

            if(possibleToShip(weights, days, mid)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args){
        ShipWithinDays sol = new ShipWithinDays();

        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;

        System.out.println(sol.shipWithinDays(weights, days)); // Output: 3
    }
}