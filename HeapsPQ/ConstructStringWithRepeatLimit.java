class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> (b-a));

        for(char c : s.toCharArray()){
            pq.add(c);
        }

        StringBuilder res = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        int count =0 ;
        char prevChar = pq.peek();

        while(!pq.isEmpty()){
            char curr = pq.poll();

            if(curr == prevChar){
                if(count < repeatLimit){
                    //add character to result string
                    res.append(curr);
                }
                else{
                    //if limit is not exhausted yet add back again to the stack
                    stack.add(curr);
                }

                count++;
            }
            else{
                if(stack.isEmpty()){
                    count = 0;
                    res.append(curr);
                    prevChar = curr;
                    count++;
                }
                else{
                    res.append(curr);
                    count = 0;
                    //filler element when previous char is not exhausted
                    while(!stack.isEmpty() && count < repeatLimit){
                        res.append(stack.pop());
                        count++;
                    }
                }
            }
        }
        return res.toString();
    }
}

// TC: O(nlogn)
// SC: O(n)