/*
    Problem: Roman to Integer

    Description:
    Convert a Roman numeral string into its integer value.
    Roman numerals are usually written largest to smallest,
    but some use subtractive notation:
        IV = 4, IX = 9, XL = 40, XC = 90, etc.

    Approach: Greedy Traversal

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Traverse the string from left to right
    - For each character:
        - If next value is greater → subtract current
        - Else → add current

    Why it works:
    - Subtractive cases always have smaller value before larger one
    - Detecting next greater value handles these cases naturally

    Notes:
    - Uses HashMap for value lookup
    - Can be optimized using array instead of map
*/

import java.util.*;

class RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < s.length(); i++){
            int curr = map.get(s.charAt(i));

            if(i + 1 < s.length() && map.get(s.charAt(i + 1)) > curr){
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        RomanToInteger sol = new RomanToInteger();

        String s = "MCMXCIV";

        System.out.println(sol.romanToInt(s)); // Output: 1994
    }
}