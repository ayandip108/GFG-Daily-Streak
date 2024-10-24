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

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        ArrayList<Integer> s=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(s.size()==0){
                s.add(arr[i]);
            }
            else if(s.get(i-1)==arr[i]){
                int t=s.get(i-1);
                s.set(i-1,t*2);
                s.add(0);
            }
            else{
                s.add(arr[i]);
            }
        }
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(s.get(i)!=0){
                arr[j]=s.get(i);
                j++;
            }
        }int k=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(s.get(i)==0){
                arr[k]=0;
                k--;
            }
        }
        for(int i=0;i<arr.length;i++){
            s.set(i,arr[i]);
        }
        return s;
    }
}
