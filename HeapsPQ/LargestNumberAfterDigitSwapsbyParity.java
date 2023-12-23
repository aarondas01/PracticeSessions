class Solution {
    public int largestInteger(int num) {
        //using maxheap

        PriorityQueue<Integer> oddPQ = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> evenPQ = new PriorityQueue<>((a,b)-> b-a);


        String str = String.valueOf(num);
        char[] ch = str.toCharArray();

        for(char c: ch){
            int n = c -'0';

            if(n%2 ==0){
                evenPQ.offer(n);
            }

            else{
                oddPQ.offer(n);
            }
        }

        String res ="";

        for(char c : ch){
            int n = c -'0';
            if(n%2==0){
                res += (evenPQ.poll()+"");
            }
            else{
                res += (oddPQ.poll()+"");
            }
        }

        return Integer.parseInt(res);
    }
}

// TC: O(nlogn)
// SC: O(n)