/*
    Problem: Longest Repeating Character Replacement
    Description:
        You are given a string s and an integer k. 
        You can choose any character of the string and change it to any other uppercase English character. 
        You can perform this operation at most k times.
        Return the length of the longest substring containing the same letter you can get after performing the above operations.
    Approach: sliding window
    Time: O(n)
    Space: O(1)
    Notes:
    - Maintain a sliding window and track frequency of characters
    - Keep track of the count of the most frequent character (maxFreq) in the window
    - The number of replacements needed = window size - maxFreq
    - If replacements needed > k, shrink the window from the left
    - Otherwise, expand the window and update the maximum length
*/

class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, maxFreq = 0, maxLength = 0, n = s.length();
        int[] freq = new int[26];

        for(int right = 0; right < n; right++){
            int idx = s.charAt(right) - 'A';

            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            while((right-left+1) - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, (right-left+1));
        }

        return maxLength;
    }

    public static void main(String[] args){
        int len = characterReplacement("AABABBA", 1);
        System.out.println(len);
    }
}