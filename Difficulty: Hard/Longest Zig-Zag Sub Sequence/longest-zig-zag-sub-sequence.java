//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.ZigZagMaxLength(nums);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int ZigZagMaxLength(int[] nums)
   {
       int ma=1;
       int mi=1;
       for(int i=1;i<nums.length;i++)
       {
           if(nums[i]>nums[i-1])
           ma=mi+1;
           else if(nums[i]<nums[i-1])
           mi=ma+1;
       }
       return Math.max(mi,ma);
   }
}