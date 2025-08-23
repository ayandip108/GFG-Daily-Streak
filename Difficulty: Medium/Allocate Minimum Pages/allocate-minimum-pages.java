class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        // students greater than books
        if(k > arr.length) return -1;
        int start = 0, end = 0;
        
        // all books can go to one student (end)
        // at least one student will get the maximum number of pages (start)
        for(int i : arr){
            end += i;
            if(i > start) start = i;
        }
        
        // classic binary search
        while(start <= end){
            int mid = start + (end-start)/2;
            
            // since we want want the minimum difference 
            if(canDo(arr, mid, k)) end = mid-1;
            
            // can't allocate so we try with big number
            else start = mid+1;
        }
        // at last "start" will contain the answer
        return start;
    }
    private static boolean canDo(int[] arr, int mid, int k){
        // at least one student will get the book
        int student = 1, currentSum = 0;
        
        for(int i : arr){
            // chosen number is smaller than array element
            // then it violets rule 1
            if(i > mid) return false;
            
            // when sum went greater than our chosen number (mid)
            if(currentSum + i > mid){
                // incrementing student
                student++;
                // resetting the counter
                currentSum = i;
                
                // when our counter went greater than available students
                if(student > k) return false;
            }
            // else keep adding pages
            else currentSum += i;
        }
        return true;
    }
}