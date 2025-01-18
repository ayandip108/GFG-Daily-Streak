//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // consume the newline

        Solution solution = new Solution();

        while (T-- > 0) {
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();

            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            for (char ch : input1.toCharArray()) {
                int tmp = ch - '0';
                Node newNode = new Node(tmp);
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            for (char ch : input2.toCharArray()) {
                int tmp = ch - '0';
                Node newNode = new Node(tmp);
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Node result = solution.subLinkedList(head1, head2);
            printList(result);
        }

        sc.close();
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    Node rev(Node head) {
        Node prev = null;
        Node curr = head;
     
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node sub(Node head1,Node head2) {
        Node ans = null;
        boolean borrow = false;
        while(head1 != null && head2 != null) {
            int data = 0;
            if(borrow) {
                borrow = (head1.data == 0 || head1.data - 1 < head2.data) ? true : false;
                
                if(head1.data == 0 || head1.data -1 < head2.data) {
                    if(head1.data == 0) data = 9 - head2.data;
                    else data = (head1.data  + 9) - head2.data;
                }
                
                else data = head1.data - 1 - head2.data;
            }
            
            else if(head1.data < head2.data) {
                data = (head1.data + 10) - head2.data;
                borrow = true;
            } 
            else data = head1.data - head2.data;
            
            Node node = new Node(data);
            node.next = ans;
            ans = node;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while(head1 != null) {
            int data = 0;
            if(borrow) {
                borrow = (head1.data == 0) ? true : false;
                data = (head1.data == 0) ? 9 : head1.data - 1;
            }
            else data = head1.data;
            Node node = new Node(data);
            node.next = ans;
            ans = node;
            head1 = head1.next;
        }
        
        while(ans.next != null && ans.data == 0) ans = ans.next;
        return ans;
    }
    boolean isLarge(Node head1,Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        
        boolean h1 = false;
        boolean h2 = false;
        while(temp1 != null && temp2 != null) {
            if(temp1.data > temp2.data && !h2 && !h1) h1 = true;
            if(temp1.data < temp2.data && !h2 && !h1) h2 = true;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
    
        if(temp1 != null) return true;
        if(temp2 != null) return false;
        
        if(h1) return true;
        return false;
        
    }
    public Node subLinkedList(Node head1, Node head2) {
        while(head1 != null && head1.data == 0) head1 = head1.next;
        while(head2 != null && head2.data == 0) head2 = head2.next;
        
        if(head1 == null && head2 == null) return new Node(0);
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        boolean h1 = false;
        boolean h2 = false;
        
        if(isLarge(head1,head2)) h1 = true;
        else h2 = true;
        
        Node ans = null;
        
        head1 = rev(head1);
        head2 = rev(head2);
       
        if(h1) ans = sub(head1,head2);
        else ans = sub(head2,head1);
        return ans;
    }
}