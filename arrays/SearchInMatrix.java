/*
    Problem: Search in a Sorted 2D Matrix

    Description:
    Given a matrix where rows are sorted and each row's first element
    is greater than the previous row's last element, search for a target.

    Approach: Binary Search on Rows + Binary Search in Row

    Time Complexity: O(log m + log n)
    Space Complexity: O(1)

    Key Idea:
    - First binary search rows using last column to find candidate row
      where target could exist (first row with last element >= target).
    - If no such row exists, return false.
    - Then binary search inside that row.

    Steps:
    1. Binary search on rows using mat[mid][cols-1]
    2. Pick row = s, validate bounds
    3. Binary search target in that row

    Notes:
    - Efficient due to row-wise and column-wise sorting properties
    - Alternative optimal method: treat matrix as 1D array
*/


public class SearchInMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;

        int s = 0, e = rows-1;
        while(s <= e){
            int m = s + (e-s)/2;
            int ele = mat[m][cols-1];

            if(ele == target) return true;
            else if(ele > target){
                e = m-1;
            }
            else {
                s = m+1;
            }
        }

        int row = s;

        if(row >= rows) return false;
        s = 0; e = cols-1;
        while(s <= e){
            int m = s + (e-s)/2;
            int ele = mat[row][m];

            if(ele == target) return true;
            else if(ele > target){
                e = m-1;
            }
            else {
                s = m+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchInMatrix sol = new SearchInMatrix();

        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println(sol.searchMatrix(mat, target1)); // true
        System.out.println(sol.searchMatrix(mat, target2)); // false
    }
}
