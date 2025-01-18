//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}

// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    private HashMap<Node, Node> parent = new HashMap<>();
    private int ans = 0;

    private void mapParent(Node root, Node[] targets, int first, int second){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.data == first) targets[0] = curr;
            if(curr.data == second) targets[1] = curr;

            if(curr.left != null){
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    private void solve(Node root, Node tNode, Map<Node, Boolean> vis, int count){
        if(root == null)    return;
        if(root.data == tNode.data){
            ans = count;
            return;
        }
        vis.put(root, true);
        count++;

        if(root.left != null && !vis.getOrDefault(root.left, false))
            solve(root.left, tNode, vis, count);
        if(root.right != null && !vis.getOrDefault(root.right, false))
            solve(root.right, tNode, vis, count);
        if(parent.containsKey(root) && !vis.getOrDefault(parent.get(root), false))
            solve(parent.get(root), tNode, vis, count);

        vis.put(root, false);
        count--;
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node[] targets = new Node[2];
        mapParent(root, targets, a, b);

        Map<Node, Boolean> vis = new HashMap<>();
        int count = 0;
        solve(targets[0], targets[1], vis, count);
        return ans;
    }
}
