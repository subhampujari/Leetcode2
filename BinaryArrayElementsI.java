public class BinaryArrayElementsI{
        public int minOperations(int[] nums) {
            int n=nums.length;
            int count=0;
            for(int i=2;i<n;i++){
                if(nums[i-2]==0){
                    count++;
                    nums[i-2]=nums[i-2]^1;
                    nums[i-1]=nums[i-1]^1;
                    nums[i]=nums[i]^1;
                }
            }
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=nums[i];
            }
            if(sum==nums.length)return count;
            return -1;
        }
}