//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countBuildings(int[] height) {
        int prevMax = height[0];
        int count = 1;
        for(int i=1; i<height.length; i++){
            if(height[i] > prevMax)
                count++;
                
            prevMax = Math.max(prevMax, height[i]);
        }
    return count;
    }
}
