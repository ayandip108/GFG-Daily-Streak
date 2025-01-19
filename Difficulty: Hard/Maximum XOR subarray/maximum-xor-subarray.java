//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            
            System.out.println(ob.maxSubarrayXOR(N,arr));
            
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    static class TrieNode {
        TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[2];
        }
    }
    
    public static int maxSubarrayXOR(int N, int arr[]) {
        // Initialize result
        int maxXor = 0;
        
        // Create prefix XOR array
        int[] prefixXor = new int[N];
        prefixXor[0] = arr[0];
        
        // Fill prefix XOR array
        for(int i = 1; i < N; i++) {
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }
        
        // Create Trie
        TrieNode root = new TrieNode();
        
        // Insert 0 into Trie to handle single element subarrays
        insert(root, 0);
        
        // Try all possible subarrays
        for(int i = 0; i < N; i++) {
            insert(root, prefixXor[i]);
            maxXor = Math.max(maxXor, getMaxXor(root, prefixXor[i]));
        }
        
        return maxXor;
    }
    
    // Insert a number into Trie
    private static void insert(TrieNode root, int num) {
        TrieNode curr = root;
        
        // Process all bits from MSB to LSB
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }
    
    // Find maximum XOR possible with given number
    private static int getMaxXor(TrieNode root, int num) {
        TrieNode curr = root;
        int maxXor = 0;
        
        // Process all bits from MSB to LSB
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            // Try to find opposite bit to maximize XOR
            if(curr.children[1-bit] != null) {
                maxXor |= (1 << i);
                curr = curr.children[1-bit];
            } else {
                curr = curr.children[bit];
            }
        }
        
        return maxXor;
    }
}