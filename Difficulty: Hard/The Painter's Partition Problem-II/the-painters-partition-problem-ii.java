//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    static long minTime(int[] arr,int k){
        int n=arr.length;
        long ans = -1;
        long low=0, high=0;
        for(int i: arr){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            long mid=(low+high)/2;
            if(isValid(arr,mid,k)){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
        
        static boolean isValid(int[] arr,long barrier,int k){
            long pages=0;
            int studentsNo = 1;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>barrier) return false;
                if(pages+arr[i]<=barrier){
                    pages+=(long)arr[i];
                }else{
                    pages=arr[i]; studentsNo++;
                }
            }
            return (studentsNo<=k)?true:false;
        }
        
    
}