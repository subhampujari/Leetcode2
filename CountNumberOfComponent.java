import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountNumberOfComponent{
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int edge[]:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Set<Integer> vist=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            int CountNode[]=new int[2];
            dfs(i,adj,vist,CountNode);
            if(CountNode[0]*(CountNode[0]-1)==CountNode[1]){
                count++;
            }
        }
        return count;
    }
       public void dfs(int curr,List<Integer>[] adj,Set<Integer> set,int[] count){
        set.add(curr);
        count[0]++;
        count[1]+=adj[curr].size();
        for(int next:adj[curr]){
            if(!set.contains(next)){
                dfs(next,adj,set,count);
            }
        }
       }
}