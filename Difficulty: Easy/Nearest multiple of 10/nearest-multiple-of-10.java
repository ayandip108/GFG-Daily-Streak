//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    StringBuilder carryAddKaro(StringBuilder str) {
        int carry = 1;
        boolean isBreak = false;
        for(int i = str.length() - 1; i >= 0; --i) {
            if(str.charAt(i) == '9') 
                str.setCharAt(i,'0');
            else {
                int num = Integer.parseInt(str.charAt(i) + "");
                ++num;
                str.setCharAt(i,(char)(num + '0'));
                isBreak = true;
                break;
            }
        }
        if(!isBreak) str.insert(0,"1");
        return str;
    }
    String roundToNearest(String str) {
        StringBuilder sb = new StringBuilder(str);
        int n = str.length();
        int num = Integer.parseInt(sb.charAt(n-1) + "");
        sb.deleteCharAt(n-1);
        int mod = num % 10;
        if(mod <= 5) {
            num = 0;
        } else {
             num = 0;
             sb = carryAddKaro(sb);
        }
        sb.append(String.valueOf(num));
        return sb.toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends