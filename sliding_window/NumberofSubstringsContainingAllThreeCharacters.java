/*
    Problem: Number of Substrings Containing All Three Characters
    Description: Given a string s consisting only of characters a, b and c.
    Return the number of substrings containing at least one occurrence of all these characters.
    Approach: Sliding window / Last occurrence tracking
    Time: O(n)
    Space: O(1)
    Notes:
    - track last occurrence of 'a', 'b', and 'c'
    - for each index, find the minimum of last seen positions
    - all substrings ending at current index and starting before min are valid
    - number of such substrings = min + 1
    - intuition: the earliest last occurrence among 'a', 'b', 'c' decides how far left we can go while still including all three characters
*/


public class NumberofSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int lastA = -1, lastB = -1, lastC = -1;
        int count = 0;
        int min;

        for(int curr = 0; curr < s.length(); curr++){
            char ch = s.charAt(curr);

            switch (ch) {
                case 'a' -> lastA = curr;
                case 'b' -> lastB = curr;
                default -> lastC = curr;
            }

            min = Math.min(Math.min(lastA, lastB), lastC);

            if(min != -1){
                count += min + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int res = numberOfSubstrings(s);
        System.out.println(res);
    }
}
