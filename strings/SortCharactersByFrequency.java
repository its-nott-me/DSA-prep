/*
    Problem: Sort Characters By Frequency

    Description:
    Given a string s, sort it in decreasing order based on the frequency
    of characters. Return the resulting string.

    Approach: Bucket Sort

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Count frequency of each character
    - Use bucket array where index = frequency
    - Store characters in corresponding buckets
    - Traverse buckets from high → low frequency
    - Append each character 'f' times

    Why it works:
    - Bucket sort avoids O(n log n) sorting
    - Frequency range is limited (0 → n)

    Notes:
    - Assumes ASCII (128 chars)
    - Efficient for large inputs
*/

import java.util.*;

class SortCharactersByFrequency {

    public String frequencySort(String s) {
        int[] freq = new int[128];

        // count frequency
        for(char c : s.toCharArray()){
            freq[c]++;
        }

        // bucket where index = frequency
        List<Character>[] buckets = new List[s.length() + 1];

        for(int i = 0; i < 128; i++){
            int f = freq[i];

            if(f > 0){
                if(buckets[f] == null){
                    buckets[f] = new ArrayList<>();
                }
                buckets[f].add((char) i);
            }
        }

        // build result
        StringBuilder sb = new StringBuilder();

        for(int f = s.length(); f > 0; f--){
            if(buckets[f] != null){
                for(char c : buckets[f]){
                    for(int i = 0; i < f; i++){
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        SortCharactersByFrequency sol = new SortCharactersByFrequency();

        String s = "tree";

        System.out.println(sol.frequencySort(s)); // Output: "eetr" or "eert"
    }
}