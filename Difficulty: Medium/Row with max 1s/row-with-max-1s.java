class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max = 0;
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            int row = 0;
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1) row++;
            }
            if(row > max) {
                max = row;
                idx = i;
            }
        }
        return idx;
    }
}