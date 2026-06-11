/*
    Problem: Find Peak Element in a 2D Grid

    Description:
    A peak element is an element that is strictly greater than its neighbors
    (left and right). In a 2D matrix, we consider neighbors in the same row.
    Return the position of any peak element.

    Approach: Binary Search on Columns

    Time Complexity: O(n log m)
    Space Complexity: O(1)

    Key Idea:
    - Do binary search on columns
    - For each middle column:
        1. Find the maximum element in that column (maxRow)
        2. Compare it with left and right neighbors
        3. If it is greater than both → peak found
        4. Else move in direction of greater neighbor

    Why it works:
    - The global peak can be guided by the local maxima of a column
    - Moving toward a greater neighbor guarantees progress toward a peak

    Notes:
    - Only left/right neighbors matter (not up/down for decision)
    - Guarantees finding at least one peak
*/

class FindPeakGrid {

    public int[] findPeakGrid(int[][] mat) {
        int leftCol = 0;
        int rightCol = mat[0].length - 1;

        while(leftCol <= rightCol){
            int midCol = leftCol + (rightCol - leftCol) / 2;

            // find max element in mid column
            int maxRow = 0;
            for(int i = 1; i < mat.length; i++){
                if(mat[i][midCol] > mat[maxRow][midCol]){
                    maxRow = i;
                }
            }

            int left = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol + 1 < mat[0].length) ? mat[maxRow][midCol + 1] : -1;

            // check peak condition
            if(mat[maxRow][midCol] >= left && mat[maxRow][midCol] >= right){
                return new int[]{maxRow, midCol};
            }

            // move toward greater neighbor
            if(left > mat[maxRow][midCol]){
                rightCol = midCol - 1;
            } else {
                leftCol = midCol + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        FindPeakGrid sol = new FindPeakGrid();

        int[][] mat = {
            {1, 4, 3},
            {6, 7, 8},
            {5, 2, 9}
        };

        int[] res = sol.findPeakGrid(mat);

        System.out.println(res[0] + " " + res[1]);
        // Output could be a valid peak like: 1 2 (value 8 or 9 depending on path)
    }
}