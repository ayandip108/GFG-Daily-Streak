class Solution {
    
    ArrayList<ArrayList<Integer>> result;
    
    private void backtrack(Stack<Integer> stack, int n, int k, int sum) {
        if(sum == n && stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        if(sum  >= n || stack.size() >= k) {
            return;
        }
        
        for(int i = 1; i < 10; i++) {
            if(!stack.isEmpty() && stack.peek() >= i) {
                continue;
            }
            stack.add(i);
            backtrack(stack, n, k, sum + i);
            stack.pop();
        }
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        result = new ArrayList<>();
        
        backtrack(new Stack<>(),n,k,0);
        return result;
    }
}