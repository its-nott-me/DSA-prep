// it is an array type problem which can be solved using memoization..
// Pascal(r,c) = Pascal(r−1,c−1) + Pascal(r−1,c)
// with both Time & Space Complexity: O(r x c)

// since we only require 1 element..
// it's efficient to solve using mathematical formula
/*
 *           n(n-1)...(n-k+1)
 * C(n,k) = -------------------
 *             k(k-1)...1
 */


public class PascalsTriangleI {
    public static int pascalTriangleI(int r, int c) {
        int n = r-1;
        int k = c-1;
        long ans = 1;

        for(int i = 0; i < k; i++){
            ans = ans * (n-i) / (k-i);
        }

        return (int) ans;
    }

    public static void main(String[] args){
      // 5C3 = 6
      int n = 5;
      int r = 3;

      System.out.println(pascalTriangleI(n, r));
    }
}