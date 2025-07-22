class Solution {
    public int missingNumber(int[] arr) {
        // code here
         int n =arr.length;
         Arrays.sort(arr);
         int small   =  1  ; 
         for(int i = 0 ;  i <n;i++){
             if(arr[i] == small){
                 small++;
                 }else {
                     if(arr[i]>small){
                         break ;
                     }
                 }
             
         }
          return small;
         
    }
}