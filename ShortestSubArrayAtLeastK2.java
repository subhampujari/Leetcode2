class ShortestSubArrayAtLeastK2{
    public int minimumSubarrayLength(int[] nums, int k) {
          int [] count=new int[32];
        if(k==0)
        {
            return 1;
        }
        int ans=Integer.MAX_VALUE;
       
        int i=0;
        int j=0;
        int temp=0;
        while(j<nums.length)
        {
            if(nums[j]==k) return 1;
           add(nums[j],count);
           while(num(count)>=k)
           {
            ans=Math.min(j-i+1,ans);
            sub(nums[i],count);
            i++;
           }
           j++;
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public void add(int nums,int [] arr)
    {
        for(int i=0;i<32;i++)
        {
            arr[i]+=((nums>>i) &1);
        }
    }
     public void sub(int nums,int [] arr)
    {
        for(int i=0;i<32;i++)
        {
            arr[i]-=((nums>>i) &1);
        }
    }
    public int num(int [] arr)
    {
        int x=0;
        for(int i=0;i<32;i++)
        {
            if(arr[i]>0)
            {
                x+=(1<<i);
            }
        }
        return x;
    }
}