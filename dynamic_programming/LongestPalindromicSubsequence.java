/*
    Problem: Longest Palindromic Subsequence (LPS)

    Description:
    Given a string s, find the length of its longest palindromic subsequence.

    A subsequence is a sequence that can be derived from a string by deleting
    some or no characters without changing the order of the remaining characters.

    A palindrome is a sequence that reads the same forward and backward.

    Approach: Dynamic Programming (Bottom-Up)

    Time Complexity: O(n²)
    Space Complexity: O(n²)

    Where:
    - n = length of the string s

    Key Idea:
    - Create a 2D DP table of size n × n.
    - dp[i][j] represents the length of the longest palindromic subsequence
      in the substring s[i...j].
    - Initialize dp[i][i] = 1 because every single character is a palindrome
      of length 1.
    - Process substrings in increasing order of length, from 2 to n.
    - For each substring s[i...j]:
        * If s.charAt(i) == s.charAt(j):
              dp[i][j] = 2 + dp[i+1][j-1]
        * Otherwise:
              dp[i][j] = max(dp[i+1][j], dp[i][j-1])
    - The answer is stored in dp[0][n-1].

    Notes:
    - We process substrings by increasing length so that the smaller
      subproblems are solved before they are needed.
    - When both endpoints match, they can be included in the palindrome.
      We add 2 to the LPS length of the inner substring.
    - When the endpoints differ, at least one endpoint must be excluded.
      We take the maximum of the two possibilities.
    - For a matching pair of adjacent characters, the inner substring is
      empty. Its LPS length is 0, so the result is 2.
    - This implementation assumes that s is non-empty.
*/

public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        // Single characters are palindromes of length 1.
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Process substrings of length 2 through n.
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                // j is the ending index.
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // Include both matching endpoints.
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    // Exclude either the left or right endpoint.
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str1 = "bbbab";
        String str2 = "mbadm";
        String str3 = "abc";
        String str4 = "a";
        String str5 = "agbdba";

        System.out.println("LPS Length 1: " + longestPalindromeSubseq(str1)); // 4

        System.out.println("LPS Length 2: " + longestPalindromeSubseq(str2)); // 2

        System.out.println("LPS Length 3: " + longestPalindromeSubseq(str3)); // 1

        System.out.println("LPS Length 4: " + longestPalindromeSubseq(str4)); // 1

        System.out.println("LPS Length 5: " + longestPalindromeSubseq(str5)); // 5
    }
}