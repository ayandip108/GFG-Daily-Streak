//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {

        //Time complexity-O(N) and Monotonic decreasing stack algorithm is used here

//Instead of comparing each day with all previous days (like in the brute-force //approach), we use a stack to store indices of previous days — but only those days //where the stock price was higher than or equal to today’s price. This lets us efficiently //“jump over” lower prices.

        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        list.add(1);
        st.push(0);//pushing index
        
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            list.add(st.isEmpty()? (i+1) : (i - st.peek()));
            st.push(i);
        }
        return list;

        // Time complexity-O(n) and brute force
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(1);
        
        // for(int i=1;i<arr.length;i++){
        //     int count=1;
        //     int j=i-1;
        //     while( j>=0  && arr[j]<=arr[i]){
        //         count++;
        //         j--;
        //     }
        //     list.add(count);
            
        // }
        // return list;
    }
    
}