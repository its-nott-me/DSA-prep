/*
    Problem: Fruit Into Basket
    Description: 
    Given a string s, find the length of the longest substring without duplicate characters.
    Approach: Sliding window 
    Time: O(n)
    Space: O(min(n, charset))
    Notes:
    - Use a sliding window with two pointers
    - Expand the window by moving right
    - If a duplicate character appears, shrink the window from the left until the duplicate is removed
    - Use a HashSet to track characters in the current window
    - Update max length at each valid window
*/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();

    if(n <= 1) {
      return n;
    }

    int right = 0, left = 0, max = 0;
    Set<Character> set = new HashSet<>();

    while(right < n){
      char ch = s.charAt(right);
      while(set.contains(ch)){
        set.remove(s.charAt(left));
        left++;
      }

      set.add(ch);
      max = Math.max(right-left+1, max);
      
      right++;
    }

  return max;
  }

  public static void main(String[] args){
    String s = "abcabcbb";
    int res = lengthOfLongestSubstring(s);
    System.out.println(res);
  }
}