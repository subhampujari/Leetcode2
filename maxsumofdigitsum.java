import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        
        for (int i = 0; i < nums.length; i++) {
            int num = findNum(nums[i]);
            
            if (map.containsKey(num)) {
                int num1 = map.get(num);
                max = Math.max(max, nums[i] + num1);
                map.put(num, Math.max(num1, nums[i]));
            } else {
                map.put(num, nums[i]);
            }
        }
        
        return max;
    }

    public int findNum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }
}