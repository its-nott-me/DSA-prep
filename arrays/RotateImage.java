/*
    Problem: Rotate Image (Rotate Matrix by 90 Degrees)

    Description:
    Given an n x n 2D matrix representing an image, rotate the matrix
    by 90 degrees clockwise in-place.

    Approach: Transpose + Reverse

    Time Complexity: O(n^2)
    Space Complexity: O(1)

    Key Idea:
    - First transpose the matrix (swap across diagonal)
    - Then reverse each row
    - This results in a 90-degree clockwise rotation

    Notes:
    - Works only for square matrices
    - In-place transformation without extra space
*/

class RotateImage {

    public static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void reverse(int[][] matrix, int row, int n) {
        int left = 0, right = n - 1;

        while(left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                swap(matrix, i, j);
            }
        }

        // reverse each row
        for(int i = 0; i < n; i++){
            reverse(matrix, i, n);
        }
    }

    public static void main(String[] args){
        RotateImage sol = new RotateImage();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        sol.rotate(matrix);

        for(int[] row : matrix){
            for(int x : row){
                System.out.print(x + " ");
            }
            System.out.println();
        }

        // Output:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}