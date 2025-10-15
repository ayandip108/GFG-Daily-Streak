/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> ob =new ArrayList<Integer>();
    public int kthSmallest(Node root, int k) {
        // code here
        traversal(root);
        if(ob.size()<k)
        return -1;
        else
        return ob.get(k-1);
    }
    void traversal(Node root){
        if(root ==null) return ;
        traversal(root.left);
        ob.add(root.data);
        traversal(root.right);
    }
} 