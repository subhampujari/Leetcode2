import java.util.ArrayList;
import java.util.List;

public class PartionLebel{
    public List<Integer> partitionLabels(String s) {
        //we can solve this questions using the itrative approach 
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<s.length();){
            int stIndex=i;
            int endIndex=s.lastIndexOf(s.charAt(stIndex));
            for(int a=stIndex+1;a<=endIndex-1;a++){
                int lastIndexOfNextChar=s.lastIndexOf(s.charAt(a));

                if( lastIndexOfNextChar >endIndex ){
                    endIndex=lastIndexOfNextChar;
                }
            }
            res.add(endIndex-stIndex+1);
            i=endIndex+1;
        }
        return res;
    }
}