class Solution {
    public int calculate(String s) {
        //using Stack
        Stack<Integer> stack = new Stack<>();

        int num = 0, res = 0, sign = 1;

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num*10 + (int)(ch-'0');
            }
            else if(ch == '+'){
                res = res + sign*num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                res = res + sign*num;
                num = 0;
                sign =-1;
            }
            else if(ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res =0 ;

            }
            else if(ch ==')'){
                res = res + sign *num;
                num =0;
                res = res * stack.pop();
                res = res + stack.pop();
            }
        }
        if(num != 0){
            res = res + sign*num;
        }

        return res;
    }
}

// TC: O(n)
// SC: O(no of brackets)ff