//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        // Initialize the pointers and current sum
        int start = 0, currentSum = 0;

        // Traverse through the array
        for (int end = 0; end < arr.length; end++) {
            // Add the current element to the current sum
            currentSum += arr[end];

            // Adjust the window size to maintain the target sum
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if the current sum equals the target
            if (currentSum == target) {
                // Add 1-based indices to the result
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }

        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }
}