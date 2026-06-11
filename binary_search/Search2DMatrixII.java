/*
    Problem: Search a 2D Matrix II

    Description:
    Given an m x n matrix where:
    - Each row is sorted in ascending order
    - Each column is sorted in ascending order
    Return true if target exists in the matrix.

    Approach: Staircase Search (Greedy from Bottom-Left)

    Time Complexity: O(m + n)
    Space Complexity: O(1)

    Key Idea:
    - Start from bottom-left corner
    - At each step:
        - If current element == target → found
        - If current element > target → move up (reduce row)
        - If current element < target → move right (increase column)

    Why it works:
    - Moving up decreases value
    - Moving right increases value
    - Each step eliminates a row or column

    Notes:
    - Efficient alternative to binary search per row
    - Works only because both rows and columns are sorted
*/

class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int currRow = matrix.length - 1;
        int currCol = 0;
        int nCol = matrix[0].length;

        while(currRow >= 0 && currCol < nCol){

            if(matrix[currRow][currCol] == target)
                return true;

            if(matrix[currRow][currCol] > target)
                currRow--;   // move up
            else
                currCol++;   // move right
        }

        return false;
    }

    public static void main(String[] args){
        Search2DMatrixII sol = new Search2DMatrixII();

        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        System.out.println(sol.searchMatrix(matrix, 5));  // true
        System.out.println(sol.searchMatrix(matrix, 15)); // false
    }
}