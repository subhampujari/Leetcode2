import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs{
     public static long countBadPairs(int[] nums) {
        /*//brute force
        long ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i<j && ((j - i) !=(nums[j] - nums[i]))){
                    ans++;
                }
            }
        }
        return ans;
        */
       long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];

            // Count of previous positions with same difference
            int goodPairsCount = diffCount.getOrDefault(diff, 0);

            // Total possible pairs minus good pairs = bad pairs
            badPairs += pos - goodPairsCount;

            // Update count of positions with this difference
            diffCount.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }
    public static void main(String[] args) {
        CountNumberOfBadPairs co=new CountNumberOfBadPairs();
        int nums[]={4,1,3,3};
        System.out.println(co.countBadPairs(nums));
    }
}