//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int [] leftSmaller = new int[n];
        stack.push(arr[0]);
        for(int i = 1;i < n;i++)
        {
            while(!stack.isEmpty() && arr[i] <= stack.peek())
                stack.pop();
            if(!stack.isEmpty())
                leftSmaller[i] = stack.peek();
            stack.push(arr[i]);
        }
        stack.clear();
        stack.push(arr[n-1]);
        int maxDif = leftSmaller[n-1];
        for(int i = n-2;i>=0;i--)
        {
            int rightSmall = 0;
            while(!stack.isEmpty() && arr[i] <= stack.peek())
                stack.pop();
            if(!stack.isEmpty())
                rightSmall = stack.peek();
            stack.push(arr[i]);
            maxDif = Math.max(maxDif, Math.abs(leftSmaller[i] - rightSmall));
        }
        return maxDif;
    }
}
