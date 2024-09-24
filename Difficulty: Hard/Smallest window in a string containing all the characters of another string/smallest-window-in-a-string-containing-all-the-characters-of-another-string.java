//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static String smallestWindow(String s, String t)
    {
        int arr1[]=new int[26];
        int arr2[]=new int[26];
        for(char ch:t.toCharArray())
        {
            arr2[ch-'a']++;
        }
        int left=0;
        int right=0;
        int maxi=(int)1e9;
        int count=0;
        int start=0;
        int end=s.length();
        while(right<s.length())
        {
            char ch=s.charAt(right);
            arr1[ch-'a']++;
            if(arr1[ch-'a']<=arr2[ch-'a'])  count++;
           while( count>=t.length())
           {
               int len=right-left+1;
               if(maxi>len)
               {
                   start=left;
                   end=right+1;
                   maxi=len;
               }
               char ch1=s.charAt(left);
               arr1[ch1-'a']--;
              if(arr1[ch1-'a']<arr2[ch1-'a']) count--;
               left++;
           }
           right++;
        }
        return maxi==(int)1e9?"-1":s.substring(start,end);
    }
}
