/*
    Problem: Search a 2D Matrix

    Description:
    You are given an m x n matrix where:
    - Each row is sorted in ascending order
    - The first integer of each row is greater than the last integer of the previous row
    Return true if target exists in the matrix, else false.

    Approach: Two-Level Binary Search

    Time Complexity: O(log m + log n)
    Space Complexity: O(1)

    Key Idea:
    - First, binary search to find the correct row:
        * Each row is like a sorted block
        * Check where target can lie based on first and last element
    - Then, binary search inside that row

    Notes:
    - Effectively treats matrix as sorted blocks + sorted row
    - Two-stage binary search
*/

class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        int mid = 0;
        int nCol = matrix[0].length;

        // step 1: find candidate row
        while(left <= right){
            mid = left + (right - left) / 2;

            if(matrix[mid][0] == target)
                return true;

            if(matrix[mid][0] < target){
                // target might be in this row
                if(matrix[mid][nCol - 1] >= target)
                    break;

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int row = mid;

        // step 2: binary search in that row
        left = 0;
        right = nCol - 1;

        while(left <= right){
            mid = left + (right - left) / 2;

            if(matrix[row][mid] == target)
                return true;

            if(matrix[row][mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Search2DMatrix sol = new Search2DMatrix();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println(sol.searchMatrix(matrix, 3));  // true
        System.out.println(sol.searchMatrix(matrix, 13)); // false
    }
}