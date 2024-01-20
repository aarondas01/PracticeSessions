class Solution {
    private Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        // using stack
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(!set.contains(s)){
                stack.push(Integer.parseInt(s));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();

                if(s.equals("+")){
                    stack.push(a+b);
                }
                else if(s.equals("-")){
                    stack.push(a-b);
                }
                else if(s.equals("*")){
                    stack.push(a*b);
                }
                else{
                    stack.push(a/b);
                }
            }

        }
        return stack.pop();
    }
}

// TC: O(n)
// SC: O(n)