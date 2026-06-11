/*
    Problem: Maximum Nesting Depth of Parentheses

    Description:
    Given a valid parentheses string s, return the maximum nesting depth.
    The nesting depth is the maximum number of open parentheses at any point.

    Approach: Counter Tracking

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Use a counter to track current depth
    - Increment when encountering '('
    - Decrement when encountering ')'
    - Track maximum value of the counter

    Why it works:
    - Depth increases with '(' and decreases with ')'
    - Maximum value reached = maximum nesting depth

    Notes:
    - Input is guaranteed to be valid parentheses string
*/

class MaximumNestingDepthOfParentheses {

    public int maxDepth(String s) {
        int max = 0;
        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
                max = Math.max(max, count);
            } 
            else if(c == ')'){
                count--;
            }
        }

        return max;
    }

    public static void main(String[] args){
        MaximumNestingDepthOfParentheses sol = new MaximumNestingDepthOfParentheses();

        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(sol.maxDepth(s)); // Output: 3
    }
}