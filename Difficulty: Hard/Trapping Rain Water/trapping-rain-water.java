class Solution {
    public int maxWater(int arr[]) 
    {
        // code here
        int n= arr.length, sum=0;
        int premax[]= new int[n];
        int postmax[]= new int[n];
        
        
        premax[0]=-1;
        int m=arr[0];
        postmax[n-1]=-1;
        for(int x=1; x<n;x++)
        {
            if(arr[x]>m)
            {
                 premax[x]= -1;
                 m=arr[x];
            }
            else
            premax[x]=m;
           
        }
        m=arr[n-1];
        
        for(int x=n-2; x>=0;x--)
        {
            if(arr[x]>m)
            {
                 postmax[x]= -1;
                 m=arr[x];
            }
            else
                postmax[x]=m;
           
        }
        for(int x=0; x<n;x++)
        {
            sum+= Math.max(Math.min(premax[x],postmax[x])-arr[x],0);
            // System.out.println(premax[x]+" "+sum+" "+ postmax[x]);
        }
            
        
        return sum;
    }
}