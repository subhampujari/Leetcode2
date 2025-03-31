public class MinimumCostForCuttingCake{
    import java.util.Arrays;

    class Solution {
        private int[][][][] dp;
    
        private int helper(int i, int j, int h, int l, int[] ho, int[] v) {
            if (j - i == 1 && l - h == 1) {
                return 0;
            }
            if (dp[i][j][h][l] != -1) {
                return dp[i][j][h][l];
            }
            
            int mini = Integer.MAX_VALUE;
    
            // Horizontal cuts
            for (int k = i + 1; k < j; k++) {
                mini = Math.min(mini, ho[k - 1] + helper(i, k, h, l, ho, v) + helper(k, j, h, l, ho, v));
            }
    
            // Vertical cuts
            for (int k = h + 1; k < l; k++) {
                mini = Math.min(mini, v[k - 1] + helper(i, j, h, k, ho, v) + helper(i, j, k, l, ho, v));
            }
    
            return dp[i][j][h][l] = mini;
        }
    
        public int minimumCost(int m, int n, int[] h, int[] v) {
            dp = new int[m + 1][m + 1][n + 1][n + 1];
            
            // Initialize dp array with -1
            for (int[][][] arr3D : dp) {
                for (int[][] arr2D : arr3D) {
                    for (int[] arr1D : arr2D) {
                        Arrays.fill(arr1D, -1);
                    }
                }
            }
            
            return helper(0, m, 0, n, h, v);
        }
    }
}    