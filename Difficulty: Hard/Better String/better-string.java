//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
       HashMap<Character,Integer>mpp1=new HashMap<>();
       HashMap<Character,Integer>mpp2=new HashMap<>();
       int dp1[]=new int [str1.length()+1];
       int dp2[]=new int [str2.length()+1];
       dp1[0]=1;
       dp2[0]=1;
       for (int i=0;i<str1.length();i++){
           if (mpp1.containsKey(str1.charAt(i))){
               dp1[i+1]=(2*dp1[i])-dp1[mpp1.get(str1.charAt(i))-1];
           }else{
               dp1[i+1]=dp1[i]*2;
           }
            mpp1.put(str1.charAt(i),i+1);
       }
       for (int i=0;i<str2.length();i++){
           if (mpp2.containsKey(str2.charAt(i))){
               dp2[i+1]=(2*dp2[i])-dp2[mpp2.get(str2.charAt(i))-1];
           }else{
               dp2[i+1]=dp2[i]*2;
           }
           mpp2.put(str2.charAt(i),i+1);
       }
       int len1=str1.length();
       int len2=str2.length();
       if (dp1[len1]>=dp2[len2]){
           return str1;
       }
       return str2;
    }
}