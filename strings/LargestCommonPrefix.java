/*
    Problem: Longest Common Prefix

    Description:
    Given an array of strings strs, find the longest common prefix
    shared among all strings. If there is no common prefix, return "".

    Approach: Horizontal Scanning (Character by Character)

    Time Complexity: O(n * m)
        where n = number of strings, m = length of shortest string
    Space Complexity: O(1)

    Key Idea:
    - Take the first string as reference
    - Compare each character of it with corresponding characters
      in all other strings
    - If mismatch occurs or any string ends → return prefix till that point

    Why it works:
    - Common prefix must match for all strings at each index
    - As soon as one string breaks the match, prefix ends

    Notes:
    - Early exit improves performance
    - Handles edge case: empty array
*/

class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        String firstStr = strs[0];

        for(int i = 0; i < firstStr.length(); i++){
            char c = firstStr.charAt(i);

            for(int j = 1; j < strs.length; j++){
                // if index out of bounds OR mismatch
                if(strs[j].length() == i || strs[j].charAt(i) != c){
                    return firstStr.substring(0, i);
                }
            }
        }

        return firstStr;
    }

    public static void main(String[] args){
        LongestCommonPrefix sol = new LongestCommonPrefix();

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(sol.longestCommonPrefix(strs)); // Output: "fl"
    }
}