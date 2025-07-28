class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int maxSum = 0;
        for(int i=0; i<mat.length; i++) {
            int sum = 0;
            for(int j=0; j<mat[0].length; j++) {
                sum += mat[i][j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        for(int i=0; i<mat.length; i++) {
            int sum = 0;
            for(int j=0; j<mat[0].length; j++) {
                sum += mat[j][i];
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        int ans = 0;
        for(int i=0; i<mat.length; i++) {
            int sum = 0;
            for(int j=0; j<mat[0].length; j++) {
                sum += mat[i][j];
            }
            ans += maxSum - sum;
        }
        
        return ans;
    }
}