/*
    Problem: Edit Distance

    Goal:
    Convert word1 → word2 with minimum operations.

    Allowed moves:
    - Insert
    - Delete
    - Replace

    DP meaning:
    dp[i][j] = min steps to convert
               word1[0..i-1] → word2[0..j-1]

    Idea:
    If same char → no cost
    If different → try all 3 operations

    Transitions:
    - match:
        dp[i][j] = dp[i-1][j-1]

    - mismatch:
        dp[i][j] = 1 + min(
            delete  → dp[i-1][j],
            insert  → dp[i][j-1],
            replace → dp[i-1][j-1]
        )

    Answer: dp[n][m]

    Time: O(n * m)
    Space: O(n * m)
*/

public class MinimumEditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else {
                    char a = word1.charAt(i-1), b = word2.charAt(j-1);

                    if(a != b){
                        dp[i][j] = 1 + Math.min(
                            dp[i-1][j-1], 
                            Math.min(dp[i][j-1], dp[i-1][j])
                        );
                    }

                    else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        System.out.println(
            "Minimum Edit Distance: " +
            minDistance(word1, word2)
        ); // Output: 3
    }
}
