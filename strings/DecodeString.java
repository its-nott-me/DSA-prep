import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
  public static String decode(String s) {
      int idx = 0, n = s.length();
      Deque<String> st = new ArrayDeque<>();

      while(idx < n){
        char c = s.charAt(idx);

        // 1-30
        if(Character.isDigit(c)){
      StringBuilder sb = new StringBuilder();
          while(idx < n && Character.isDigit(s.charAt(idx))){
            sb.append(s.charAt(idx));
            idx++;
          }
          st.push(sb.toString());
          idx--;
        }

        // a-z
        else if(c >= 'a' && c <= 'z'){
        StringBuilder sb = new StringBuilder();
          while(idx < n && Character.isLowerCase(s.charAt(idx))){
            sb.append(s.charAt(idx));
            idx++;
          }
          st.push(sb.toString());
          idx--;
        }

        // '['
        else if (c == '['){
          st.push(c + "");
        }

        // ']'
        else {
          StringBuilder sb = new StringBuilder();
          while(!st.isEmpty() && !st.peek().equals("[")){
            sb.insert(0, st.pop());
          }
          st.pop();
          int num = Integer.parseInt(st.pop());
          
          String p = sb.toString();
          sb.setLength(0);
          for(int k = 0; k < num; k++){
            sb.append(p);
          }

          st.push(sb.toString());
        }

        idx++;
      }
      
      StringBuilder sb = new StringBuilder();
      while(!st.isEmpty()){
        sb.insert(0, st.pop());
      }
      return sb.toString();
  }
  public static void main(String[] args) {
      System.out.println(decode("ba3[a2[b]c]"));
  }
}
