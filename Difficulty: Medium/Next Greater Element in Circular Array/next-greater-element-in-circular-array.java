class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = arr[i % n];

            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }

            if (i < n) {
                temp[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(num);
        }
        for (int val : temp) {
            res.add(val);
        }

        return res;
    }
}