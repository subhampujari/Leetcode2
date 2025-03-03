public class LPSAtMostKOper{
        int[][][] memo;
    
        public int longestPalindromicSubsequence(String s, int k) {
            int n = s.length();
            memo = new int[n][n][k + 1];
    
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int l = 0; l <= k; l++)
                        memo[i][j][l] = -1;
    
            return dp(s, 0, n - 1, k);
        }
    
        private int dp(String s, int l, int r, int k) {
            if (l > r) return 0;
            if (l == r) return 1;
            if (memo[l][r][k] != -1) return memo[l][r][k];
    
            if (s.charAt(l) == s.charAt(r)) {
                memo[l][r][k] = 2 + dp(s, l + 1, r - 1, k);
            } else {
                int cost = costToMatch(s.charAt(l), s.charAt(r));
    
                int matchWithOp = 0;
                if (cost <= k) {
                    matchWithOp = 2 + dp(s, l + 1, r - 1, k - cost);
                }
    
                int skipLeft = dp(s, l + 1, r, k);
                int skipRight = dp(s, l, r - 1, k);
    
                memo[l][r][k] = Math.max(matchWithOp, Math.max(skipLeft, skipRight));
            }
            return memo[l][r][k];
        }
        
        private int costToMatch(char a, char b) {
            int diff = Math.abs(a - b);
            return Math.min(diff, 26 - diff);
        }
}