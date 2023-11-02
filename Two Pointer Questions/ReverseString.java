class Solution {
    public void reverseString(char[] s) {
        //two pointer
        int start = 0 , end = s.length-1;
        while(start < end){
            char temp = s[start];
            s[start]=s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public void reverseString(char[] s) {
        //using stack
        Stack<Character> stack = new Stack();
        for(char c : s){
            stack.push(c);
        }
        for(int i = 0 ; i < s.length; i++){
            s[i] = stack.pop();
        }

    }
}

// TC: O(n)
// SC: O(n)