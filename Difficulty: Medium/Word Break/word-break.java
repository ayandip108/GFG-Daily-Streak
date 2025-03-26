//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        
        Set<String> set = new HashSet<>();
            int maxLength =0;
        for(String word :dictionary){
            set.add(word);
            maxLength = Math.max(word.length(), maxLength);
        }
        
        int n = s.length();
         boolean dp[] = new boolean[n+1];
         dp[0] = true;
         
            for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= Math.max(0,i-maxLength); j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            }
        return dp[n];
        
    }
}