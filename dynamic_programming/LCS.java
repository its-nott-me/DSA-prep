/*
    Problem: Longest Common Subsequence (LCS)

    Description:
    Given two strings str1 and str2, find the length of their longest
    common subsequence.

    A subsequence is a sequence that can be derived from a string by deleting
    some or no characters without changing the order of the remaining characters.

    Approach: Dynamic Programming

    Time Complexity: O(m × n)
    Space Complexity: O(m × n)

    Where:
    - m = length of str1
    - n = length of str2

    Key Idea:
    - Create a DP table of size (m + 1) × (n + 1).
    - dp[i][j] represents the length of the LCS between:
          str1[0...i-1] and str2[0...j-1]
    - For each character pair:
        * If the characters match:
              dp[i][j] = dp[i-1][j-1] + 1
        * Otherwise:
              dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    - The answer is stored in dp[m][n].

    Notes:
    - Using an extra row and column simplifies boundary conditions.
    - When characters match, we extend dp[i-1][j-1] instead of using
      dp[i-1][j] or dp[i][j-1].
    - The top and left states may already have accounted for one of the
      matching characters, so extending them could double-count the match.
    - The diagonal state represents prefixes where the current matching
      characters have not yet been considered, making it safe to add 1.
*/

class LCS {
    public static int lcs( String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
      String str1 = "abcde";
      String str2 = "ace";

      String str3 = "AGGTAB";
      String str4 = "GXTXAYB";

      String str5 = "abc";
      String str6 = "def";

      System.out.println("LCS Length 1: " + lcs(str1, str2)); // 3
      System.out.println("LCS Length 2: " + lcs(str3, str4)); // 4
      System.out.println("LCS Length 3: " + lcs(str5, str6)); // 0
  }
}

