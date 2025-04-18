//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2; // Ceiling division
        while (gap > 0) {
            int i = 0, j = gap;       
            while (j < (n + m)) {       
                int first = (i < n) ? a[i] : b[i - n];
                int second = (j < n) ? a[j] : b[j - n];           
                if (first > second) {
                    if (i < n && j < n) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    } else if (i < n && j >= n) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    } else if (i >= n && j >= n) {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                i++;
                j++;
            }
            gap = (gap == 1) ? 0 : (gap + 1) / 2; // Ceiling division
        }
    }
}