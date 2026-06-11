/*
    Problem: Set Matrix Zeroes

    Description:
    Given an m x n matrix, if an element is 0, set its entire row and column to 0.
    Do it in-place.

    Approach: Marker Technique (Using First Row & First Column)

    Time Complexity: O(m * n)
    Space Complexity: O(1)

    Key Idea:
    - Use first row and first column as markers to track which rows/columns should be zeroed
    - First, separately check if first row or first column originally contains zero
    - Then mark rows/columns using matrix[i][0] and matrix[0][j]
    - Finally, update inner matrix based on markers
    - Handle first row and first column at the end

    Notes:
    - Avoids extra space like separate row/column arrays
    - Critical to handle first row/column separately to prevent overwrite issues
*/

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // check first column
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        // check first row
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        // mark rows and columns
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // update inner matrix
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // update first row
        if(firstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // update first column
        if(firstColumnZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args){
        SetMatrixZeroes sol = new SetMatrixZeroes();

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        sol.setZeroes(matrix);

        for(int[] row : matrix){
            for(int x : row){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        // Output:
        // 1 0 1
        // 0 0 0
        // 1 0 1
    }
}