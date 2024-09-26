//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    public int maxStep(int arr[]) {
        int ans = 0;
        int cnt = 0;
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i+1] > arr[i]) {
                cnt++;
                ans = Math.max(cnt,ans);
            }
            else {
                cnt = 0;
            }
        }
      return ans;    
    }
}
