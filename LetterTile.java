import java.util.HashSet;
import java.util.Set;

public class LetterTile{
    public int numTilePossibilities(String tiles) {
        Set<String> set=new HashSet<>();
        int n=tiles.length();
        boolean isVist[]=new boolean[n];
        solve(tiles,"",set,isVist);
        return set.size()-1;
    }
    public void solve(String tiles,String temp,Set<String> res,boolean isVist[]){
        res.add(temp);
        for(int pos=0;pos<tiles.length();pos++){
            if(!isVist[pos]){
                isVist[pos]=true;
                solve(tiles,temp+tiles.charAt(pos),res,isVist);
                isVist[pos]=false;
            }           
        }
    }
}
