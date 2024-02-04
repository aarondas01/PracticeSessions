class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c =='{' || c == '[' || c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty() || (stack.peek() == '(' && c !=')') || (stack.peek() == '{'
                        && c != '}')  || (stack.peek()=='[' && c != ']')){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// TC: O(n)
// SC: O(n)