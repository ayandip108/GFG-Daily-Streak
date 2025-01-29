//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        if(e<0){
            return 1/power(b,-e);
        }
        if(e==0){
            if(b<0 || b>0){
                return 1.0;
            }
            else if(b==0){
                return 0.0;
            }
        }
        
        double ans = power(b, e/2);
        
        if(e%2==0){
            return ans*ans;
        }
        else {
            return b*ans*ans;
        }
        
    }
}

//{ Driver Code Starts.
// } Driver Code Ends