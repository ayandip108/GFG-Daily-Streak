//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   public void func(ArrayList<ArrayList<Character>> board, ArrayList<ArrayList<ArrayList<Integer>>> ans, ArrayList<ArrayList<Integer>> temp, int idx) {
        if (idx == board.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < board.size(); i++) {
            boolean flagup = true;
            boolean flagleft = true;
            boolean flagright = true;
            for (int row = 0; row < idx; row++) {
                if (board.get(row).get(i) == 'Q') {
                    flagup = false;
                    break;
                }
            }
            int row = idx - 1;
            int col = i - 1;
            while (row >= 0 && col >= 0) {
                if (board.get(row).get(col) == 'Q') {
                    flagleft = false;
                    break;
                }
                row--;
                col--;
            }
            row = idx - 1;
            col = i + 1;
            while (row >= 0 && col < board.size()) {
                if (board.get(row).get(col) == 'Q') {
                    flagright = false;
                    break;
                }
                row--;
                col++;
            }
            if (flagup && flagleft && flagright) {
                board.get(idx).set(i, 'Q');
                ArrayList<Integer> pos = new ArrayList<>();
                pos.add(idx);  // row
                pos.add(i);    // column
                temp.add(pos);
                func(board, ans, temp, idx + 1);
                board.get(idx).set(i, '.');
                temp.remove(temp.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add('.');
            }
            board.add(temp);
        }

        ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        func(board, ans, temp, 0);
        ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
        for (ArrayList<ArrayList<Integer>> solution : ans) {
            Collections.sort(solution, Comparator.comparingInt(o -> o.get(0)));
            ArrayList<Integer> sortedCols = new ArrayList<>();
            for (ArrayList<Integer> pos : solution) {
                sortedCols.add(pos.get(1)+1);
            }
            finalans.add(sortedCols);
        }
        return finalans;
    }
}
