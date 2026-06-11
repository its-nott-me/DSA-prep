/*
    Problem: String to Integer (atoi)

    Description:
    Implement the myAtoi(string s) function which converts a string
    to a 32-bit signed integer following rules similar to C/C++ atoi:
    - Ignore leading whitespaces
    - Handle optional '+' or '-' sign
    - Read digits until non-digit is found
    - Clamp result to 32-bit signed integer range

    Approach: Recursive Parsing (Custom + Overflow Handling)

    Time Complexity: O(n)
    Space Complexity: O(n) (recursion stack)

    Key Idea:
    - Skip leading spaces
    - Detect sign
    - Parse digits recursively
    - Build number while checking overflow
    - Apply sign at the end

    Notes:
    - This implementation builds number in recursion
    - Uses negative accumulation to avoid overflow issues
*/

class StringToIntegerAtoi {

    public int helperFunction(String s, int pos, int res){
        if(pos >= s.length() || !Character.isDigit(s.charAt(pos)))
            return res;

        int digit = s.charAt(pos) - '0';

        // overflow check (attempting safe accumulation)
        if(res < (Integer.MIN_VALUE + digit) / 10)
            return Integer.MIN_VALUE;

        res = (res * 10) - digit; // building in negative form

        return helperFunction(s, pos + 1, res);
    }

    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        int pos = 0;
        int sign = 1;
        int res = 0;

        // skip leading spaces
        while(pos < s.length() && s.charAt(pos) == ' '){
            pos++;
        }

        // handle sign
        if(pos < s.length() && (s.charAt(pos) == '+' || s.charAt(pos) == '-')){
            if(s.charAt(pos) == '-')
                sign = -1;
            pos++;
        }

        // skip leading zeros
        while(pos < s.length() && s.charAt(pos) == '0'){
            pos++;
        }

        res = helperFunction(s, pos, 0);

        // overflow handling
        if(res == Integer.MIN_VALUE){
            if(sign == -1) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        return sign == 1 ? -res : res;
    }

    public static void main(String[] args){
        StringToIntegerAtoi sol = new StringToIntegerAtoi();

        System.out.println(sol.myAtoi("42"));              // 42
        System.out.println(sol.myAtoi("   -42"));          // -42
        System.out.println(sol.myAtoi("4193 with words"));// 4193
        System.out.println(sol.myAtoi("words 987"));      // 0
    }
}