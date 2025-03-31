//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        int idx[] = new int[26];
        for(int i=0;i<s.length();i++) {
            idx[s.charAt(i)-'a'] = i;
        }
        
        int cnt = 0;
        int last = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            last = Math.max(last, idx[ch - 'a']);
            if(last == i){
                cnt++;
            }
        }
        return cnt;
    }
}