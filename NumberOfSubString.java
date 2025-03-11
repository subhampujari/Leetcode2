public class NumberOfSubString {
   
        public int numberOfSubstrings(String s) {
            int total=0;
            int left=0;
            int right=0;
            int n=s.length();
            int count[]=new int[3];
            while(right<n){
                char ch=s.charAt(right);
                count[ch-'a']++;
                while(isPossible(count)){
                    total+=n-right;
                    char ch1=s.charAt(left);
                    count[ch1-'a']--;
                    left++;
                }
                right++;
            }
            return total;
        }
        public boolean isPossible(int []count){
            return count[0]>0 && count[1]>0 && count[2]>0;
        }
}
