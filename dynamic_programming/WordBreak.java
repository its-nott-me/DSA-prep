/*
    Problem: Word Break

    Description:
    Given a string s and a dictionary of words wordDict, determine whether
    s can be segmented into a space-separated sequence of one or more
    dictionary words.

    A dictionary word may be reused multiple times.

    Approach: Dynamic Programming + HashSet

    Time Complexity: O(n * L^2)
    - n = length of the string
    - L = length of the longest word in the dictionary
    - Up to L substrings are checked for each position, and creating a
      substring costs O(L).

    Space Complexity: O(n + m)
    - O(n) for the DP array.
    - O(m) for the HashSet storing dictionary words.

    Key Idea:
    - Let dp[i] represent whether the prefix s[0...i-1] can be segmented
      into valid dictionary words.
    - Initialize dp[0] = true because an empty string is always segmentable.
    - Store all dictionary words in a HashSet for O(1) average lookup.
    - Let maxLen be the length of the longest dictionary word.
      For every position i, only check previous positions j where
      (i - j) <= maxLen, since longer substrings cannot exist in
      the dictionary.
    - If dp[j] is true and s.substring(j, i) exists in the dictionary,
      then dp[i] is true.

    Notes:
    - Using a HashSet provides fast dictionary lookups.
    - Limiting the inner loop using maxLen avoids unnecessary substring
      checks and improves performance.
    - The DP array stores whether each prefix of the string is breakable.
*/


import java.util.HashSet;
import java.util.List;

class WordBreak{
    public static boolean wordBreak(String s, List<String> wordDict) {
        // Your code goes here
        if(wordDict.isEmpty()) return false;

        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> dict = new HashSet<>();
        int maxLen = 0;

        for (String word : wordDict){
            dict.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            int j = Math.max(0, i-maxLen);
            for(; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        List<String> dict1 = List.of("leet", "code");
        List<String> dict2 = List.of("apple", "pen");
        List<String> dict3 = List.of("cats", "dog", "sand", "and", "cat");

        System.out.println(wordBreak("leetcode", dict1));      // true
        System.out.println(wordBreak("applepenapple", dict2)); // true
        System.out.println(wordBreak("catsandog", dict3));     // false
    }
}