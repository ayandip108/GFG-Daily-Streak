//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int fpro = 1;
        int bpro = 1;
        int max = Integer.MIN_VALUE;
        for(int i =0,j=n-1;i<n;i++,j--){
            fpro *=arr[i];
            bpro *=arr[j];
            if(bpro>max){
                max = bpro;
                
            }
            if(fpro>max){
                max = fpro;
            }
              if(fpro==0){
                fpro = 1;
            }
            if(bpro==0){
                bpro = 1;
            }

        }
        return max;
    }
}