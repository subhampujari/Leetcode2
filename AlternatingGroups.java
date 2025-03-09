public class AlternatingGroups{
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int res=0;
            int n=colors.length + k - 1;
            int len=1;
            int lastColor=colors[0];
            for(int i=1;i<n;i++){
                int right=i%colors.length;
                if(colors[right]==lastColor){
                    len=1;
                    lastColor=colors[right];
                    continue;
                }
                len++;
                if(len>=k){
                    res++;
                }
                lastColor=colors[right];
            }
            return res;
        }
}