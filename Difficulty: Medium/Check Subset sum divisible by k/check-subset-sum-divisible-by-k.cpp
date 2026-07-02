class Solution {
  public:
    bool divisibleByK(vector<int>& arr, int k) {
        // code here
        int dp[1003][1003][2];
        memset(dp, -1, sizeof(dp));
        int n = arr.size();
        
        auto f = [&](auto&& f, int i, int rem, bool picked)->bool{
            if(i==n){
                return rem==0 && picked;
            }  
            if(dp[i][rem][picked]!=-1) return dp[i][rem][picked];
            
            return dp[i][rem][picked] = f(f, i+1, (rem+arr[i])%k, 1) || f(f, i+1, rem, picked);
        };
        
        return f(f,0,0,0);
    }
};