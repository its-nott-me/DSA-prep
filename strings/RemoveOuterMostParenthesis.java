/*
    Problem: Remove Outermost Parentheses

    Description:
    A valid parentheses string is composed of primitive valid parentheses.
    For each primitive substring, remove its outermost parentheses and
    return the final string.

    Approach: Counter Tracking (Greedy)

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Use a counter to track current depth of parentheses
    - For '(':
        - Increase count first
        - Only add to result if count > 1 (skip outermost)
    - For ')':
        - Decrease count first
        - Only add to result if count > 0 (skip outermost)

    Why it works:
    - Outer parentheses are exactly those that make count go from:
        0 → 1 (opening) and 1 → 0 (closing)
    - By skipping these transitions, we remove outer layers

    Notes:
    - StringBuilder used for efficient string concatenation
*/

class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
                if(count > 1) sb.append(c);
            } else {
                count--;
                if(count > 0) sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        RemoveOutermostParentheses sol = new RemoveOutermostParentheses();

        String s = "(()())(())";

        System.out.println(sol.removeOuterParentheses(s)); // Output: "()()()"
    }
}