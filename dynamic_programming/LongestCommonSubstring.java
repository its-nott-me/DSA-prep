/*
    Problem: Longest Common Substring

    Description:
    Given two strings str1 and str2, find the length of their longest
    common substring.

    A substring is a contiguous sequence of characters within a string.
    Unlike a subsequence, the characters must appear consecutively.

    Approach: Dynamic Programming (Space Optimized)

    Time Complexity: O(m × n)
    Space Complexity: O(n)

    Where:
    - n = length of str1
    - m = length of str2

    Key Idea:
    - Use two 1D DP arrays: prev and next, each of size (n + 1).
    - prev[j] represents the length of the longest common suffix of:
          str1[0...j-1] and the previously processed prefix of str2.
    - next[j] represents the length of the longest common suffix of:
          str1[0...j-1] and the current prefix of str2.
    - For each character pair:
        * If the characters match:
              next[j] = prev[j-1] + 1
        * Otherwise:
              next[j] = 0
    - Update maxLen whenever a longer common substring is found.
    - Copy next into prev after processing each character of str2.
    - The answer is stored in maxLen.

    Notes:
    - A substring must contain consecutive characters.
    - When characters do not match, the current common substring ends,
      so next[j] must be reset to 0.
    - Unlike Longest Common Subsequence, we do not take the maximum
      of the top and left states.
    - The diagonal state extends the common substring by one character.
    - Using two 1D arrays reduces space complexity from O(m × n) to O(n).
    - The extra column at index 0 handles empty prefixes.
*/

import java.util.Arrays;

public class LongestCommonSubstring {

    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[] prev = new int[n + 1];
        int[] next = new int[n + 1];

        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    next[j] = prev[j - 1] + 1;

                    maxLen = Math.max(maxLen, next[j]);
                } else {
                    next[j] = 0;
                }
            }

            prev = Arrays.copyOf(next, n + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();

        String str1 = "abcde";
        String str2 = "abfce";

        String str3 = "GeeksforGeeks";
        String str4 = "GeeksQuiz";

        String str5 = "abc";
        String str6 = "def";

        System.out.println("Longest Common Substring Length 1: "
                + obj.longestCommonSubstr(str1, str2)); // 2

        System.out.println("Longest Common Substring Length 2: "
                + obj.longestCommonSubstr(str3, str4)); // 5

        System.out.println("Longest Common Substring Length 3: "
                + obj.longestCommonSubstr(str5, str6)); // 0
    }
}