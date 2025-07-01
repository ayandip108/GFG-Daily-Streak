class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n - k+1; i++){
            String tmpStr = s.substring(i, i+k);
            int [] tmpArr = new int[26];
            int count = 0;
            for (int j = 0; j < tmpStr.length(); j++){
                if (tmpArr[tmpStr.charAt(j) - 'a'] == 0){
                    count++;
                    tmpArr[tmpStr.charAt(j) - 'a']++;
                }
            }
            if (count == k-1)
                ans++;
        }
        return ans;
    }
}