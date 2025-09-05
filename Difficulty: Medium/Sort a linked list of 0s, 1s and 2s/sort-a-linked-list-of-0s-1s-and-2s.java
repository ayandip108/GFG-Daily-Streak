class Solution {
    public Node segregate(Node head) {
        // code here
        int[] mp = new int[3];
        Node temp = head;
        while(temp!=null){
            mp[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(mp[0]!=0){
                temp.data = 0;
                mp[0]--;
            }
            else if(mp[0]==0 && mp[1]!=0){
                temp.data = 1;
                mp[1]--;
            }
            else{
                temp.data = 2;
                mp[2]--;
            }
            temp = temp.next;
        }
        
        return head;
    }
}