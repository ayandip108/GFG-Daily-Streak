//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   static int rec(int[] keys,int[] freq,int level,int s,int e,int[][][] dp){
       if(s > e){
           return 0;
       }else if(s == e){
           return (level * freq[s]);
       }
       if(dp[s][e][level] != -1)
           return dp[s][e][level];
       int min = Integer.MAX_VALUE;
       for(int i = s; i <= e; i++){
           int res = rec(keys,freq,level+1,s,i-1,dp) + (freq[i]*level) + rec(keys,freq,level+1,i+1,e,dp);
           if(min > res) min = res;
       }
       return dp[s][e][level] = min;
   }
   
   static int optimalSearchTree(int keys[], int freq[], int n)
   {
       if(n == 1){
           return freq[0];
       }
       int dp[][][] = new int[n+1][n+1][n+1];
       for(int i = 0; i < n; i++){
           for(int j = 0; j < n; j++){
               Arrays.fill(dp[i][j],-1);
           }
       }
       int min = Integer.MAX_VALUE;
       for(int i = 0; i < n; i++){
           int result = rec(keys,freq,2,0,i-1,dp) + freq[i] + rec(keys,freq,2,i+1,n-1,dp);
           if(result < min) min = result;
       }
       return min;
   }
}
