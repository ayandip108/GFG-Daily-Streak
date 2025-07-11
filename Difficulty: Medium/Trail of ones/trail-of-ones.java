class Solution {
    public int countConsec(int n) {
        // code here
        int[][][] dp = new int[n][3][2];
        for(int[][] mat : dp) {
            for(int[] row : mat) Arrays.fill(row,-1);
        }
        int ans = solve(0,n,-1,0,dp);
        return ans;
    }
    
    private int solve(int curLen,int reqLen,int prev,int isPairSet,int[][][] dp){
        if(curLen == reqLen){
            return isPairSet == 1 ? 1 : 0;
        }
        if(dp[curLen][prev+1][isPairSet] != -1) return dp[curLen][prev+1][isPairSet];
        int zero = solve(curLen+1,reqLen,0,isPairSet,dp);

        int one = solve(curLen+1,reqLen,1,(prev == 1 || isPairSet == 1) ? 1 : 0,dp);

        return dp[curLen][prev+1][isPairSet] = zero + one;
    }
}
