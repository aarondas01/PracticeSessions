class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //sliding window
        int n = points.length;
        int res = Integer.MIN_VALUE;

        int r = 0 , x = 0;
        for(int l = 0 ; l < n ; l++){
            int c = Integer.MIN_VALUE;
            if(x > l && x <= r){
                c= points[x][0] - points[l][0] + points[l][1] + points[x][1];
            }
            r = x+1 > l ? x+1 : l+1;
            while(r < n && points[r][0] - points[l][0] <= k){
                if(points[r][0] - points[l][0] + points[l][1] + points[r][1] >= c){
                    c = points[r][0] - points[l][0] + points[l][1] + points[r][1];
                    x = r;
                }
                r++;
            }
            res = Math.max(res,c);
        }
        return res;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < points.length; i++){
            // pick the index at the front of deque and if the difference
            // between current x and x in peeked index is greater than k
            // then we dont need the peeked value in deque so remove it using poll
            while(!queue.isEmpty() && points[i][0] - points[queue.peek()][0] > k){
                queue.poll();
            }
            // now the difference of current point's x and x of the front index of
            // deque will be <= k so calculate ans
            if(!queue.isEmpty()){
                ans = Math.max(ans,points[i][0] + points[i][1] + points[queue.peek()][1] - points[queue.peek()][0]);
            }
            // if the non checked values i.e. the difference of y - x of indexes at the
            // end of deque is smaller than current y - x then we don't need those values
            // as we already have the greater value so remove the indexes from end using pollLast()
            while(!queue.isEmpty() && points[queue.peekLast()][1] - points[queue.peekLast()][0]  < points[i][1] - points[i][0]){
                queue.pollLast();
            }
            queue.addLast(i);
        }
        return ans;
    }
}
// TC: O(n)
// SC: O(n)