public class OrderTripllet{
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        long highest_diff=0;
        long highest=0;
        for(int num:nums){
            ans=Math.max(ans,highest_diff*num);
            highest_diff=Math.max(highest_diff,highest-num);
            highest=Math.max(highest,num);
        }
        return ans;
    }
}