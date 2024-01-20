class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        int element = output.pop();

        while(!output.isEmpty()){
            input.push(output.pop());
        }
        return element;
    }

    public int peek() {
        while(!input.isEmpty()){
            output.push(input.pop());
        }

        int peeked = output.peek();

        while(!output.isEmpty()){
            input.push(output.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//  TC: O(n)
//  SC: O(n)