class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int remove = k;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            while (!st.isEmpty() && remove > 0 && st.peek() < ch) {
                st.pop();
                remove--;
            }
            st.push(ch);
        }

        while (remove > 0) {
            st.pop();
            remove--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }

        return sb.toString();
    }
}