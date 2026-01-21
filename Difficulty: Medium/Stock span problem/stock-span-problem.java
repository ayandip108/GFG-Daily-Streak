class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        ArrayList<Integer> ans =
        new ArrayList<>(Collections.nCopies(arr.length, 0));

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {

            // -------- TIME COMPLEXITY EXPLANATION IN CODE --------
            // Every index is pushed once into stack.
            // Every index is popped at most once.
            // So even if this while loop looks nested,
            // total pops across whole program = arr.length.
            // Therefore amortized work per iteration = O(1).
            // Final Time Complexity of entire loop = O(n).
            //------------------------------------------------------

            while (!st.empty() && arr[st.peek()] <= arr[i]) {
                st.pop();   // this index will never be popped again → popped once only
            }

            if (st.empty()) {
                ans.set(i, i + 1);
            } else {
                ans.set(i, i - st.peek());
            }

            st.push(i);  // pushed once only → contributes to O(n)
        }

        // OVERALL:
        // Push operations = n
        // Pop operations = n
        // Total operations <= 2n → O(n)

        return ans;
    }
}