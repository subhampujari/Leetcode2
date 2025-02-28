public class ShortestCommonSubsquence{
    public String shortestCommonSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        // Fill dp table for LCS (Longest Common Subsequence)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {  // Corrected condition here
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the shortest supersequence from the dp table
        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (i > 0 && (j == 0 || dp[i - 1][j] > dp[i][j - 1])) {
                ans.append(a.charAt(i - 1));
                i--;
            } else if (j > 0) {
                ans.append(b.charAt(j - 1));
                j--;
            }
        }

        // Reverse the string to get the final supersequence
        ans.reverse();
        return ans.toString();
    }
}