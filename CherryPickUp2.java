import java.util.Arrays;

public class CherryPickUp2{
    class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][][]=new int[n][m][m];
        for(int d[][]:dp){
            for(int l[]:d){
                Arrays.fill(l,-1);
            }
        }
        return solve(0,0,m-1,grid,dp);
    }
    public int solve(int row, int col1,int col2,int[][] grid,int dp[][][]){
        int rows=grid.length;
        int cols=grid[0].length;

        if(col1<0 || col2<0 || col1>=cols || col2>=cols)return 0;

        if(dp[row][col1][col2]!=-1)return dp[row][col1][col2];

        int cherries=grid[row][col1];
        if(col1!=col2)cherries+=grid[row][col2];

        if(row==rows-1)return cherries;

        int maxCherries=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                maxCherries=Math.max(maxCherries,solve(row+1,col1+i,col2+j,grid,dp));
            }
        }

        return dp[row][col1][col2]=cherries+maxCherries;
    }
}
}