/*
    Problem: Valid Anagram

    Description:
    Given two strings s and t, return true if t is an anagram of s,
    otherwise return false.
    An anagram means both strings contain the same characters with
    the same frequencies.

    Approach: Sorting

    Time Complexity: O(n log n)
    Space Complexity: O(n)

    Key Idea:
    - Convert both strings to character arrays
    - Sort both arrays
    - If sorted arrays are equal → they are anagrams

    Why it works:
    - Sorting arranges characters in order
    - Equal frequency + same characters → identical sorted arrays

    Notes:
    - Simple and clean approach
    - Can be optimized to O(n) using frequency array
*/

import java.util.*;

class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();

        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        return Arrays.equals(sortedS, sortedT);
    }

    public static void main(String[] args){
        ValidAnagram sol = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        System.out.println(sol.isAnagram(s, t)); // true
    }
}