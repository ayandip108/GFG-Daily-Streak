//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean mark(int[][] matrix, int N, int M, int i, int j) {
        boolean ret = true;
        if(i>=0 && i<N && j>=0 && j<M && matrix[i][j] == 1) {
           matrix[i][j] = 0;
           if(i==0 || i==N-1 || j==0 || j==M-1) {
                ret = false;
           }
           ret &= mark(matrix, N, M, i-1, j);
           ret &= mark(matrix, N, M, i+1, j);
           ret &= mark(matrix, N, M, i, j-1);
           ret &= mark(matrix, N, M, i, j+1);
        }
        return ret;
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int counter = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(matrix[i][j] == 1 && 
                   mark(matrix, N, M, i, j)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}