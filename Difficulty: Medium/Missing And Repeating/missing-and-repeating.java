//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int[] sol=new int[2];
        long n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++)
        {
               if(arr[i]==arr[i+1])
               {
                   sol[0]=arr[i];
                   break;
               }
        }
        long sum_actual=0;
        
        for(int i=0;i<n;i++)
        {
            sum_actual+=arr[i];
        }
        long sum_expected=((n*(n+1))/2);
       long x=sum_expected-(sum_actual-(long)sol[0]);
       sol[1]=(int)x;
        return sol;
    }
}
