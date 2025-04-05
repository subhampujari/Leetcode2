import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayIncresingOrder{
        Map<String, Integer> memo = new HashMap<>();
    
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            Arrays.sort(arr2);
            // Remove duplicates from arr2
            arr2 = Arrays.stream(arr2).distinct().toArray();
    
            int res = dfs(arr1, arr2, 0, -1);
            return res >= 2001 ? -1 : res; // 2001 = max possible ops + 1
        }
    
        private int dfs(int[] arr1, int[] arr2, int i, int prev) {
            if (i == arr1.length) return 0;
    
            String key = i + "," + prev;
            if (memo.containsKey(key)) return memo.get(key);
    
            int minOps = 2001;
    
            // Option 1: Don't replace arr1[i]
            if (arr1[i] > prev) {
                minOps = dfs(arr1, arr2, i + 1, arr1[i]);
            }
    
            // Option 2: Replace arr1[i] with next greater in arr2
            int replacement = upperBound(arr2, prev);
            if (replacement < arr2.length) {
                int take = 1 + dfs(arr1, arr2, i + 1, arr2[replacement]);
                minOps = Math.min(minOps, take);
            }
    
            memo.put(key, minOps);
            return minOps;
        }
    
        // Finds first index in arr that is greater than target
        private int upperBound(int[] arr, int target) {
            int left = 0, right = arr.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= target) left = mid + 1;
                else right = mid;
            }
            return left;
        }
}