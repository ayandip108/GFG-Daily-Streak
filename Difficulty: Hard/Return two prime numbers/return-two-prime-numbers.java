//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isp(int a){
        
        for(int i=2;i*i<=a;i++){
            if(a%i==0)return false;
            
        }
        return true;
    }
    static List<Integer> primeDivision(int n) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=2;i<=n/2;i++){
            
        boolean a=isp(i);
        boolean b=isp(n-i);
        
        if(a && b){
            al.add(i);
            al.add(n-i);
            return al;
        }

            
        
            
        }    
        return al;
        
    }}