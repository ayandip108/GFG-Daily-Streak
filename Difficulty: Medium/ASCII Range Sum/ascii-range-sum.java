class Solution {
    public ArrayList<Integer> asciirange(String s) {
        HashSet<Character> hs=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            hs.add(s.charAt(i));
        }
        int total=0;
        for(int i=0;i<n;i++){
            total+=(int)s.charAt(i);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(char ch:hs){
            int x=total;
            for(int i=0;i<n;i++){
                x-=(int)s.charAt(i);
                if(s.charAt(i)==ch){
                    break;
                }
            }
            for(int i=n-1;i>=0;i--){
                x-=(int)s.charAt(i);
                if(s.charAt(i)==ch){
                    break;
                }
            }
            if(x>0){
            list.add(x);
            }
        }
        return list;
    }
}