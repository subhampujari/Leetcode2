import java.util.HashMap;

public class TupleWithSameProduct{
    public int tupleSameProduct(int[] nums) {
      /*  int n=nums.length;
        int count=0;
        Map<Long,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               long multi=nums[i]*nums[j];
                map.put(multi,map.getOrDefault(multi,0)+1);
            }
        }
        for(long key:map.keySet()){
            int produt=map.get(key);
            int pair=((produt-1)*produt)/2;
            count+=8 * pair;
        }
        return count;*/
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product = nums[i]*nums[j];
                count+=(map.getOrDefault(product,0)*8);
                map.merge(product,1,Integer::sum);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        TupleWithSameProduct tu=new TupleWithSameProduct();
        int arr[]={2,3,4,6};
        System.out.println(tu.tupleSameProduct(arr));// answer is 8
    }
}