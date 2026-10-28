/*
    Problem: Delete Operation for Two Strings

    Description:
    Given two strings word1 and word2, find the minimum number of
    character deletions required to make both strings equal.

    Approach: Dynamic Programming (Space Optimized LCS)

    Time Complexity: O(n × m)
    Space Complexity: O(n)

    Where:
    - n = length of word1
    - m = length of word2

    Key Idea:
    - Find the Longest Common Subsequence (LCS) of word1 and word2.
    - Characters belonging to the LCS can be retained in both strings.
    - All other characters must be deleted to make the strings equal.
    - Therefore:
          Minimum Deletions = n + m - 2 × LCS

    DP Definition:
    - Use two 1D arrays: prev and next, each of size (n + 1).
    - prev[j] represents the LCS length between:
          word1[0...j-1] and the previously processed prefix of word2.
    - next[j] represents the LCS length between:
          word1[0...j-1] and the current prefix of word2.

    Transitions:
    - If the characters match:
          next[j] = prev[j-1] + 1
    - Otherwise:
          next[j] = max(next[j-1], prev[j])

    - After processing each character of word2, copy next into prev.
    - The final LCS length is stored in prev[n].
    - The answer is n + m - 2 × prev[n].

    Notes:
    - Each string may require deletions independently.
    - The LCS characters are retained in both strings.
    - Characters outside the LCS must be deleted from their respective
      strings.
    - The extra column at index 0 represents an empty prefix.
    - The arrays are reused to reduce space complexity from O(n × m)
      to O(n).
*/

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[n + 1];
        int[] next = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    next[j] = prev[j - 1] + 1;
                } else {
                    next[j] = Math.max(next[j - 1], prev[j]);
                }
            }

            int[] temp = prev;
            prev = next;
            next = temp;

            Arrays.fill(next, 0);
        }

        // Minimum deletions = n + m - 2 * LCS length.
        return n + m - 2 * prev[n];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        String word3 = "leetcode";
        String word4 = "etco";

        String word5 = "abc";
        String word6 = "def";

        String word7 = "abc";
        String word8 = "abc";

        System.out.println("Minimum Deletions 1: " + minDistance(word1, word2)); // 2

        System.out.println("Minimum Deletions 2: " + minDistance(word3, word4)); // 4

        System.out.println("Minimum Deletions 3: " + minDistance(word5, word6)); // 6

        System.out.println("Minimum Deletions 4: " + minDistance(word7, word8)); // 0
    }
}