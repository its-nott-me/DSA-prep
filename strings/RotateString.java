/*
    Problem: Rotate String

    Description:
    Given two strings s and goal, return true if and only if s can become
    goal after some number of rotations.
    A rotation means moving the first character of s to the end.

    Approach: String Trick (Concatenation)

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - If we concatenate s with itself → s + s
    - All possible rotations of s will be substrings of (s + s)
    - So just check if goal is a substring of (s + s)

    Why it works:
    - Rotations are cyclic shifts
    - Doubling the string simulates all possible cyclic rotations

    Notes:
    - Lengths must be equal, otherwise impossible
*/

class RotateString {

    public boolean rotateString(String s, String goal) {

        // length mismatch → not possible
        if(goal.length() != s.length())
            return false;

        String doubleString = s + s;

        return doubleString.contains(goal);
    }

    public static void main(String[] args){
        RotateString sol = new RotateString();

        String s = "abcde";
        String goal = "cdeab";

        System.out.println(sol.rotateString(s, goal)); // true
    }
}