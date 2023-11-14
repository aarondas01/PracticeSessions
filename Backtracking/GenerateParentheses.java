class Solution {
    public List<String> generateParenthesis(int n) {

        //backtracking
        List<String>   result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0,0,n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combo , int open, int close, int n){
        if(close > open){
            return;
        }
        if(combo.length() == 2*n && close == open){
            result.add(combo.toString());
            return;
        }

        if(open < n){
            combo.append("(");
            backtrack(result,combo,open+1,close,n);
            combo.deleteCharAt(combo.length()-1);
        }
        if(close < open){
            combo.append(")");
            backtrack(result,combo,open,close+1,n);
            combo.deleteCharAt(combo.length()-1);
        }
    }
}

// TC: O(2*2^n)
// SC: O(n)