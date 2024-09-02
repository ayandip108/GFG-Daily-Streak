//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean isValid(int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n;
    }
    public int minimumCostPath(int[][] grid)
    {
        int n=grid.length;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,-1,0,1};
        int distance[][]=new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) distance[i][j]=(int)(1e9);
        distance[0][0]=grid[0][0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()) {
            int curr[]=pq.remove();
            int i=curr[0];
            int j=curr[1];
            int dist=curr[2];
            if(i==n-1 && j==n-1) return dist;
            for(int x=0;x<4;x++) {
                int newRow=i+delRow[x];
                int newCol=j+delCol[x];
                if(isValid(newRow,newCol,n)) {
                    if(dist+grid[newRow][newCol]<distance[newRow][newCol]) {
                        distance[newRow][newCol]=dist+grid[newRow][newCol];
                        pq.add(new int[]{newRow,newCol,distance[newRow][newCol]});
                    }
                }
            }
        }
        return -1;
    }
}
