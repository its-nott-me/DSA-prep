/*
    Problem: Shortest Common Supersequence

    Description:
    Given two strings str1 and str2, find the shortest string that
    contains both str1 and str2 as subsequences.

    Approach: Dynamic Programming (LCS) + String Reconstruction

    Time Complexity: O(n × m)
    Space Complexity: O(n × m)

    Where:
    - n = length of str1
    - m = length of str2

    Key Idea:
    - Find the Longest Common Subsequence (LCS) of str1 and str2.
    - Characters belonging to the LCS can be shared by both strings.
    - All other characters must be included separately in the result.
    - Therefore:
          Length of SCS = n + m - LCS length
    - The shortest common supersequence can be constructed by merging
      both strings around their common subsequence.

    DP Definition:
    - Use a 2D array dp of size (n + 1) × (m + 1).
    - dp[i][j] represents the length of the LCS between:
          str1[0...i-1] and str2[0...j-1].

    Transitions:
    - If the characters match:
          dp[i][j] = dp[i-1][j-1] + 1
    - Otherwise:
          dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    Approach 1: shortestCommonSupersequence()
    - First, calculate the LCS length using the DP table.
    - Backtrack through the table to reconstruct the LCS.
    - Reverse the reconstructed LCS to obtain its original order.
    - Traverse both strings and append the characters appearing before
      each common LCS character.
    - Append each common character only once.
    - Finally, append the remaining characters of both strings.

    Approach 2: optimizedShortestCommonSupersequence()
    - Calculate the same LCS DP table.
    - Backtrack from dp[n][m] toward dp[0][0].
    - If the current characters match, append the character once and
      move diagonally.
    - Otherwise, append the character from the direction that preserves
      the longer LCS.
    - Append any remaining characters from either string.
    - Reverse the result because reconstruction proceeds backward.

    Notes:
    - Both methods return a shortest common supersequence.
    - The first method reconstructs the LCS before merging the strings.
    - The second method directly constructs the supersequence by
      backtracking through the DP table.
    - Multiple shortest common supersequences may exist.
    - Both methods use O(n × m) time and O(n × m) space.
*/

public class ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(
            String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build the LCS DP table.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        // Reconstruct the LCS by backtracking through the DP table.
        StringBuilder sb = new StringBuilder();

        int i = n, j = m;

        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        String lcs = sb.reverse().toString();

        // Merge both strings using their LCS.
        sb.setLength(0);
        i = 0;
        j = 0;

        for (int k = 0; k < lcs.length(); k++) {
            char curr = lcs.charAt(k);

            // Append characters from str1 before the common character.
            while (str1.charAt(i) != curr) {
                sb.append(str1.charAt(i));
                i++;
            }

            // Append characters from str2 before the common character.
            while (str2.charAt(j) != curr) {
                sb.append(str2.charAt(j));
                j++;
            }

            // Append the common character only once.
            sb.append(curr);
            i++;
            j++;
        }

        // Append any remaining characters from str1.
        while (i < n) {
            sb.append(str1.charAt(i));
            i++;
        }

        // Append any remaining characters from str2.
        while (j < m) {
            sb.append(str2.charAt(j));
            j++;
        }

        return sb.toString();
    }

    public static String optimizedShortestCommonSupersequence(
            String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build the LCS DP table.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        // Construct the shortest common supersequence backward.
        StringBuilder sb = new StringBuilder();

        int i = n, j = m;

        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                // Common character: append once and move diagonally.
                sb.append(str1.charAt(i - 1));
                i--;
                j--;

            } else if (dp[i][j - 1] > dp[i - 1][j]) {

                // Take a character from str2.
                sb.append(str2.charAt(j - 1));
                j--;

            } else {

                // Take a character from str1.
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        // Append remaining characters from str1.
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        // Append remaining characters from str2.
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse because the result was constructed backward.
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String str1 = "abac";
        String str2 = "cab";

        String str3 = "aaaaaaaa";
        String str4 = "aaaaaaaa";

        String str5 = "abc";
        String str6 = "def";

        String str7 = "geek";
        String str8 = "eke";

        // Test Case 1
        System.out.println(
                "Shortest Common Supersequence 1: "
                + shortestCommonSupersequence(str1, str2)
        ); // Expected: cabac

        System.out.println(
                "Optimized SCS 1: "
                + optimizedShortestCommonSupersequence(str1, str2)
        ); // Expected: cabac

        // Test Case 2
        System.out.println(
                "Shortest Common Supersequence 2: "
                + shortestCommonSupersequence(str3, str4)
        ); // Expected: aaaaaaaa

        System.out.println(
                "Optimized SCS 2: "
                + optimizedShortestCommonSupersequence(str3, str4)
        ); // Expected: aaaaaaaa

        // Test Case 3
        System.out.println(
                "Shortest Common Supersequence 3: "
                + shortestCommonSupersequence(str5, str6)
        ); // Expected: defabc or another valid SCS

        System.out.println(
                "Optimized SCS 3: "
                + optimizedShortestCommonSupersequence(str5, str6)
        ); // Expected: defabc or another valid SCS

        // Test Case 4
        System.out.println(
                "Shortest Common Supersequence 4: "
                + shortestCommonSupersequence(str7, str8)
        ); // Expected: gekek

        System.out.println(
                "Optimized SCS 4: "
                + optimizedShortestCommonSupersequence(str7, str8)
        ); // Expected: gekek
    }
}