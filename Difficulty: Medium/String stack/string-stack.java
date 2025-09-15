class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        for(int k=0;k<pat.length();k++){
            int j=0; int i=0;
        if(pat.charAt(k)==tar.charAt(j)){    
            i=k; j=0;
        while(i<pat.length()&&j<tar.length()){
            if(pat.charAt(i)==tar.charAt(j)){
                i++; j++;
            }
         else {
              if(j==0)
              i++;
             else 
              i+=2;
          }    
         }
        }
      if(j==tar.length()&&(pat.length()-i)%2==0)
       return true;
        }
       return false;
    }
}