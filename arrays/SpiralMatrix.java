/*
    Problem: Spiral Matrix

    Description:
    Given an m x n matrix, return all elements of the matrix
    in spiral order.

    Approach: Boundary Traversal

    Time Complexity: O(m * n)
    Space Complexity: O(1) (excluding output list)

    Key Idea:
    - Maintain four boundaries: top, bottom, left, right
    - Traverse:
        1. Left → Right (top row)
        2. Top → Bottom (right column)
        3. Right → Left (bottom row)
        4. Bottom → Top (left column)
    - Shrink boundaries after each traversal

    Notes:
    - Check boundaries before traversing bottom row and left column
    - Prevents duplicate traversal in single row/column cases
*/

import java.util.*;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if(matrix == null || matrix.length == 0) return list;

        int top = 0, left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while(bottom >= top && right >= left){

            // left → right
            for(int j = left; j <= right; j++)
                list.add(matrix[top][j]);
            top++;

            // top → bottom
            for(int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;

            // right → left
            if(top <= bottom){
                for(int j = right; j >= left; j--)
                    list.add(matrix[bottom][j]);
                bottom--;
            }

            // bottom → top
            if(left <= right){
                for(int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);
                left++;
            }
        }

        return list;
    }

    public static void main(String[] args){
        SpiralMatrix sol = new SpiralMatrix();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> res = sol.spiralOrder(matrix);

        for(int x : res){
            System.out.print(x + " ");
        }
        // Output: 1 2 3 6 9 8 7 4 5
    }
}