import java.util.Arrays;

public class HouseRobberII{
    public boolean isPossible(int m, int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= m) {
                i += 2;
                k--;
            } else {
                i++;
            }
            if (k == 0) return true;
        }
        return false;
    }

    public int minCapability(int[] nums, int k) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        
        while (l < r) {
            int m = (l + r) / 2;
            if (isPossible(m, nums, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}