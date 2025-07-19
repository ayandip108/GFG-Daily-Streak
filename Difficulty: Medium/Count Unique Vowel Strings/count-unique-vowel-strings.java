class Solution {
    
    public boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            return true;
        }
        
        return false;
    }
    
    
    public int fact(int n)
    {
        if(n == 0) return 1;
        
        return n*fact(n-1);
    }
    
    public int vowelCount(String s) {

        HashMap<Character, Integer> mpp = new HashMap<>();
        
        for(char ch : s.toCharArray())
        {
            if(isVowel(ch)) mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
        }
        
        
        if(mpp.isEmpty()) return 0;
        
        int choice = 1;
        
        for(int val : mpp.values())
        {
            choice = choice*val;
        }
        
        
        
        int dist = mpp.size();
        
        int res = choice*fact(dist);
        
        return res;
    }
}

