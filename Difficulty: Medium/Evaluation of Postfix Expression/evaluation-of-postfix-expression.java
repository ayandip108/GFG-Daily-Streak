//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st =new Stack<>();
        for(int i=0 ;i<arr.length;i++)
        {
            try {  
                int str = Integer.parseInt(arr[i]); 
                st.add(str);
            } catch(NumberFormatException e){  
                
                int num=0;
                int op1=st.pop();
                int op2=st.pop();
                
                if(arr[i].equals("*"))
                    num=op2*op1;
                else if(arr[i].equals("+"))
                    num=op2+op1;
                else if(arr[i].equals("-"))
                    num=op2-op1;
                else if(arr[i].equals("/"))
                    num=op2/op1;
                    
                st.push(num);
              }  
        }
        return st.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends