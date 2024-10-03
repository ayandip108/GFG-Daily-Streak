//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n = nums.size();
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MAX_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != nums.get(i)) {
                cnt1++;
                ele1 = nums.get(i);
            } else if (cnt2 == 0 && ele1 != nums.get(i)) {
                cnt2++;
                ele2 = nums.get(i);
            } else if (ele1==nums.get(i)) {
                cnt1++;
            } else if (ele2==nums.get(i)) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i: nums) {
            if (i == ele1) {
                cnt1++;
            }
            if (i == ele2) {
                cnt2++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (cnt1 > n / 3) {
            ans.add(ele1);
        }
        if (cnt2 > n / 3) {
            ans.add(ele2);
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
        
    }
}
