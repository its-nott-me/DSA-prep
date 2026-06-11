/*
    Problem: Reverse Words in a String

    Description:
    Given a string s, reverse the order of words.
    A word is defined as a sequence of non-space characters.
    The result should not contain leading/trailing spaces,
    and multiple spaces between words should be reduced to one.

    Approach: Split + Reverse

    Time Complexity: O(n)
    Space Complexity: O(n)

    Key Idea:
    - Trim the string to remove leading/trailing spaces
    - Split using regex "\\s+" to handle multiple spaces
    - Traverse the array in reverse order
    - Build result using StringBuilder

    Notes:
    - "\\s+" ensures multiple spaces are treated as one delimiter
    - StringBuilder is used for efficient concatenation
*/

class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--){
            res.append(arr[i]);
            if(i > 0) res.append(" ");
        }

        return res.toString();
    }

    public static void main(String[] args){
        ReverseWordsInString sol = new ReverseWordsInString();

        String s = "  the sky   is blue  ";

        System.out.println(sol.reverseWords(s)); // Output: "blue is sky the"
    }
}