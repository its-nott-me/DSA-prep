/*
    Problem: Isomorphic Strings

    Description:
    Two strings s and t are isomorphic if characters in s can be replaced
    to get t, with a one-to-one mapping between characters.
    No two characters in s can map to the same character in t.

    Approach: HashMap + Reverse Check

    Time Complexity: O(n)
    Space Complexity: O(1) (at most 256 characters)

    Key Idea:
    - Maintain mapping from s → t
    - For each character:
        1. If already mapped → check consistency
        2. If not mapped:
            - Ensure target character is not already used
            - Then create mapping

    Why it works:
    - Ensures one-to-one mapping (bijection)
    - Prevents two characters mapping to same character

    Notes:
    - containsValue() makes it slightly less optimal (O(n) per check)
    - Can be optimized using two maps or arrays
*/

import java.util.*;

class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Character> char_map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char char_of_s = s.charAt(i);
            char char_of_t = t.charAt(i);

            if(char_map.containsKey(char_of_s)){
                if(char_map.get(char_of_s) != char_of_t){
                    return false;
                }
            } else {
                // ensure no two chars map to same target
                if(char_map.containsValue(char_of_t)){
                    return false;
                }
                char_map.put(char_of_s, char_of_t);
            }
        }

        return true;
    }

    public static void main(String[] args){
        IsomorphicStrings sol = new IsomorphicStrings();

        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";

        System.out.println(sol.isIsomorphic(s1, t1)); // true
        System.out.println(sol.isIsomorphic(s2, t2)); // false
    }
}