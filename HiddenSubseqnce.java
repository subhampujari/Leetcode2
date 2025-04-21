public class HiddenSubseqnce{
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            int curr=0;
            int low=0;
            int high=0;
            for(int num:differences){
                curr+=num;
                low=Math.min(low,curr);
                high=Math.max(high,curr);
                if((high-low) > (upper-lower))return 0;
            }
            return (upper-lower) - (high-low) +1;
        }
    }
}