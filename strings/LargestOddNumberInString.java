/*
    Problem: Largest Odd Number in String

    Description:
    Given a numeric string num, return the largest-valued odd number
    (as a substring) that is a prefix of num.
    If no odd number exists, return an empty string.

    Approach: Reverse Scan

    Time Complexity: O(n)
    Space Complexity: O(1) (ignoring output string)

    Key Idea:
    - An odd number must end with an odd digit (1, 3, 5, 7, 9)
    - Traverse from right to left:
        - Find the first odd digit
        - Return substring from 0 to that index (inclusive)
    - If no odd digit is found → return ""

    Why it works:
    - Any prefix ending at that index will be the largest possible odd number
    - We want the longest prefix ending with an odd digit

    Notes:
    - Character to digit conversion: (char - '0')
*/

class LargestOddNumberInString {

    public String largestOddNumber(String num) {

        for(int i = num.length() - 1; i >= 0; i--){
            int digit = num.charAt(i) - '0';

            if(digit % 2 != 0){
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args){
        LargestOddNumberInString sol = new LargestOddNumberInString();

        String num = "35427";

        System.out.println(sol.largestOddNumber(num)); // Output: "35427"
    }
}