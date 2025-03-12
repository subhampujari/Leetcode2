public class CountPositiviandNegative{
        public int maximumCount(int[] nums) {
            int countEven=0;
            int countOdd=0;
            int n=nums.length;
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    continue;
                }else if(nums[i]>0){
                    countEven++;
                }else{
                    countOdd++;
                }
            }
            return Math.max(countOdd,countEven);
        }
}