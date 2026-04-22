class Solution {
    public ArrayList<Integer> findMean(int arr[], int queries[][]) {
        
        int n = arr.length;
        int q = queries.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int sum_arr[] = new int[n + 1];
        sum_arr[0] = 0;

        for (int i = 0; i < n; i++) {
            sum_arr[i + 1] = sum_arr[i] + arr[i];
        }

        for (int i = 0; i < q; i++) {

            int start = queries[i][0];
            int end = queries[i][1] + 1;

            int sum = sum_arr[end] - sum_arr[start];

            int avg = sum / (end - start);

            ans.add(avg);
        }

        return ans;
    }
}

