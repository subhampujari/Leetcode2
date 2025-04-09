import java.util.HashSet;
import java.util.Set;

public class MiniMumOpeartionToMaeArrayEqualToK{
      public int minOperations(int[] nums, int k) {
         int res=0;
         Set<Integer> set=new HashSet<>();

         for(int num:nums){
            set.add(num);
         }
         for(int num:set){
            if(num>k){
                res++;
            }else if(num <k){
                return -1;
            }
         }
         return res;
    }
}