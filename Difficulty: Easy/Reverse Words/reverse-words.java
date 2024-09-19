//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        StringBuilder sb = new StringBuilder();
        String res = "";
        List<String> l = new ArrayList<String>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != '.'){
                sb.append(str.charAt(i));
            }
            if(str.charAt(i) == '.'){
                l.add(sb.toString());
                l.add(".");
                sb.setLength(0);
                continue;
            }
            if(i==str.length()-1){
                l.add(sb.toString());
            }
        }
        for(int i=l.size()-1;i>=0;i--){
            res = res+l.get(i);
        }
        
        return res;
    }
}
