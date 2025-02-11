class Solution {
    public String removeOccurrences(String s, String part) {
      /*  Stack<Character> st=new Stack<>();
        int partLength=part.length();
        int sLength=s.length();

        for(int i=0;i<sLength;i++){
            st.push(s.charAt(i));
            if(st.size()>=partLength && check(st,part,partLength)){
                for(int j=0;j<partLength;j++){
                    st.pop();
                }
            }
        }
        StringBuilder sb= new StringBuilder();
          while(!st.isEmpty()){
            sb.append(st.pop());
          }
          sb.reverse();
          return sb.toString();
    }
    public boolean check(Stack<Character> st,String part,int partLength){
        Stack<Character> stk=new Stack<>();
        stk.addAll(st);

        for(int i=partLength-1;i>=0;i--){
            if(stk.isEmpty()|| stk.peek()!=part.charAt(i)){
                return false;
            }
            stk.pop();
        }
        return true;
    }*/
     StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
}
}