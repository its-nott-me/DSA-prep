/*
    Problem: Fruit Into Basket
    Description: 
        There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
        The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:
        1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
        2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
        3) Once reaching a tree with fruit that cannot fit into any basket, stop.
        Return the maximum number of fruits that can be picked.
        Approach: Sliding window 
    Time: O(n)
    Space: O(1)
    Notes:
    - Maintain a window with at most 2 distinct fruits
    - Track the last seen index of each fruit in the window
    - When a third fruit appears:
        - Remove the fruit with the smaller last occurrence
        - Move the left pointer just after that index
    - Continuously update the maximum window size
*/

public class FruitIntoBasket {
    public int totalFruits(int[] fruits) {
        int fruit1 = -1, fruit2 = -1;
        int last1 = -1, last2 = -1;
        int max = 0, n = fruits.length;

        int left = 0;

        for(int right = 0; right < n; right++){
            int curr = fruits[right];

            // first fruit
            if(curr == fruit1){
                last1 = right;
            }
            
            // second fruit
            else if(curr == fruit2) {
                last2 = right;
            }

            // if third fruit 
            else {
                if(last1 < last2){
                    left = last1+1;
                    fruit1 = curr;
                    last1 = right;
                } 

                else {
                    left = last2 + 1;
                    fruit2 = curr;
                    last2 = right;
                }
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }

    public static void main(String[] args) {
        FruitIntoBasket sol = new FruitIntoBasket();
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(sol.totalFruits(fruits));
    }
}






















