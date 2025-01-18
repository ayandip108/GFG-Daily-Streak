//{ Driver Code Starts
// Initial Template for Java
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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution{
    int time;
    void DFS(int s,ArrayList<ArrayList<Integer>> adj,int[] disc,int[] parent,
              int[] low,boolean[] visited,boolean[] ap){
        
        visited[s]=true;
        int children=0;
        low[s]=++time;
        disc[s]=time;
        
        for(int u:adj.get(s)){
            
            if(visited[u]==false){
                children++;
                parent[u]=s;
                DFS(u,adj,disc,parent,low,visited,ap);
                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[s]=Math.min(low[u],low[s]);
                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more chilren.
                if(parent[s]==-1 && children>1){
                    ap[s]=true;
                }
                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                else if(parent[s]!=-1 && low[u]>=disc[s]){
                    ap[s]=true;
                }
                
            }
            
            // Update low value of u for parent function calls.
            else if(u!=parent[s]){
                low[s]=Math.min(low[s],disc[u]);
            }
        }
    }
    public ArrayList<Integer> articulationPoints(int V,
                                ArrayList<ArrayList<Integer>> adj){
        
        int[] disc=new int[V];
        boolean visited[]=new boolean[V];
        int[] low=new int[V];
        boolean[] ap=new boolean[V];
        int[] parent=new int[V];
        Arrays.fill(parent,-1);
        
        time=0;
        DFS(0,adj,disc,parent,low,visited,ap);
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(ap[i]){
                res.add(i);
            }
        }
        
        if(res.size()==0){
            res.add(-1);
        }
        
        return res;
        
    }
}