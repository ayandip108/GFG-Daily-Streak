//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> ar1, List<Integer> ar2) {
       int sum1 = 0, sum2 = 0, i = 0, j = 0, result = 0;
        
        while(i<ar1.size() || j<ar2.size()){
            
            if(j==ar2.size() || (i<ar1.size() && ar1.get(i) < ar2.get(j))){
                sum1 += ar1.get(i);
                i++;
            }
            else if(i==ar1.size() || (j<ar2.size() && ar1.get(i) > ar2.get(j))){
                sum2 += ar2.get(j);
                j++;
            }
            else{
                result += Math.max(sum1, sum2) + ar1.get(i);
                sum1 = 0; 
                sum2 = 0; 
                i++; 
                j++;
            }
        }
        result += Math.max(sum1, sum2);
        return result;
    }
}
