//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        long minc = 0;
        while (!pq.isEmpty()) {
            long first = pq.poll();
            if (pq.isEmpty()) break;
            long second = pq.poll();
            minc = minc + (first + second);
            pq.add(first + second);
        }
        return minc;
    }
}
