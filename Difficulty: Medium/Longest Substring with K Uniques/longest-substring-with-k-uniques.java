class Solution {

    public int longestKSubstr(String s, int k) {

      int unique=0,i=0,len=-1;

      int[]freq=new int[26];

      for(int j=0;j<s.length();j++){

         int c=s.charAt(j)-'a';

          freq[c]++;

          if(freq[c]==1) unique++;

          if(unique>k){

               c=s.charAt(i)-'a';

              freq[c]--;

              if(freq[c]==0)

              unique--;

              

              i++;

          }

          if(unique==k)

          len=Math.max(len,j-i+1);

      }

      return len;

        

    }

}