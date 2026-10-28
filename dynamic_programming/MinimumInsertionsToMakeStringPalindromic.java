/*
    Problem: Minimum Insertions to Make a String Palindromic

    Description:
    Given a string s, find the minimum number of insertions required
    to make the string a palindrome.

    A palindrome is a string that reads the same forward and backward.

    Approach: Dynamic Programming (Longest Palindromic Subsequence)

    Time Complexity: O(n²)
    Space Complexity: O(n²)

    Where:
    - n = length of the string s

    Key Idea:
    - Find the length of the Longest Palindromic Subsequence (LPS).
    - Characters belonging to the LPS can remain in their original positions.
    - All remaining characters must be inserted in appropriate positions
      to make the entire string a palindrome.
    - Therefore:
          Minimum Insertions = n - LPS length

    DP Definition:
    - Create a 2D DP table of size n × n.
    - dp[i][j] represents the length of the longest palindromic subsequence
      in the substring s[i...j].

    Transitions:
    - Initialize dp[i][i] = 1 because a single character is a palindrome.
    - Process substrings in increasing order of length, from 2 to n.
    - If the characters at both endpoints match:
          dp[i][j] = 2 + dp[i+1][j-1]
    - Otherwise:
          dp[i][j] = max(dp[i+1][j], dp[i][j-1])

    - The LPS length is stored in dp[0][n-1].
    - The final answer is n - dp[0][n-1].

    Notes:
    - We use the Longest Palindromic Subsequence rather than the
      Longest Common Substring because subsequences can contain gaps.
    - When the endpoints match, both can be included in the palindrome.
    - When they differ, we exclude one endpoint and choose the better
      of the two remaining subsequences.
    - This implementation assumes that s is non-empty.
*/

public class MinimumInsertionsToMakeStringPalindromic {

    public static int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        // Single characters are palindromes of length 1.
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Process substrings of length 2 through n.
        for (int len = 2; len <= n; len++) {

            // i is the starting index.
            for (int i = 0; i + len - 1 < n; i++) {

                // j is the ending index.
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // Include both matching endpoints.
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    // Exclude either the left or right endpoint.
                    dp[i][j] = Math.max(dp[i + 1][j],
                                        dp[i][j - 1]);
                }
            }
        }

        // Minimum insertions = string length - LPS length.
        return n - dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str1 = "zzazz";
        String str2 = "mbadm";
        String str3 = "leetcode";
        String str4 = "a";
        String str5 = "abc";

        System.out.println("Minimum Insertions 1: " + minInsertions(str1)); // 0

        System.out.println("Minimum Insertions 2: " + minInsertions(str2)); // 2

        System.out.println("Minimum Insertions 3: " + minInsertions(str3)); // 5

        System.out.println("Minimum Insertions 4: " + minInsertions(str4)); // 0

        System.out.println("Minimum Insertions 5: " + minInsertions(str5)); // 2
    }
}