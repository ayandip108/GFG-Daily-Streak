//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) return head;

        Node prev = null;
        Node current = head;
        Node next;
        Node init = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != init);

        head.next = prev;
        head = prev;
        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) return head;

        Node current = head;
        Node prev = null;

        while (current.data != key) {
            if (current.next == head) {
                // Node with data not found in the list
                return head;
            }
            prev = current;
            current = current.next;
        }

        if (current == head && current.next == head) {
            // Only one node in the list
            head = null;
            return head;
        }

        if (current == head) {
            // Deleting the head node
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = current.next;
            prev.next = head;
        } else if (current.next == head) {
            // Deleting the last node
            prev.next = head;
        } else {
            // Deleting a node in between
            prev.next = current.next;
        }
        return head;
    }
}
