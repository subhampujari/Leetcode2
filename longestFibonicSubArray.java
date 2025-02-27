import java.util.HashMap;

public class longestFibonicSubArray{
    
     public int lenLongestFibSubseq(int[] arr) {
      int n = arr.length;
        
        // Map to store the index of each number in the array
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // DP table: dp[i][j] means the length of Fibonacci-like subsequence ending with arr[i] and arr[j]
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Iterate over each pair of elements (arr[i], arr[j]) where i < j
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // We want to find if there exists an element arr[k] such that arr[k] = arr[j] - arr[i]
                int target = arr[j] - arr[i];
                if (target < arr[i] && indexMap.containsKey(target)) {
                    int k = indexMap.get(target); // The index of arr[k]
                    dp[i][j] = dp[k][i] + 1; // Extend the sequence ending at arr[k] and arr[i]
                } else {
                    dp[i][j] = 2; // Any pair of elements can start a subsequence
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen >= 3 ? maxLen : 0; // If no Fibonacci-like subsequence, return 0
    }
}
