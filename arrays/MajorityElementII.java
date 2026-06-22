import java.util.*;

public class MajorityElementII {
    public static List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        int a = 0;
        int countA = 0;
        int b = 0;
        int countB = 0;

        for(int i : nums){
          if(a == i){
            countA++;
          } 
          
          else if(b == i) {
            countB++;
          } 

          else if(countA == 0){
              a = i;
              countA = 1;
          } 
          
          else if (countB == 0){
              b = i;
              countB = 1;
          }
          
          else {
              countA--;
              countB--;
          }
        }

        List<Integer> res = new ArrayList<>();

        countA = 0;
        countB = 0;
        for(int i: nums){
          if(a == i) countA++;
          else if(b == i) countB++;
        }

        if(countA > n/3){
            res.add(a);
        }

        if(a != b && countB > n/3){
            res.add(b);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 2, 2, 3, 3};
        System.out.println(majorityElementTwo(nums).toString());
    }
}