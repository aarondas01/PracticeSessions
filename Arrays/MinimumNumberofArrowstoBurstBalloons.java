//Array Intervals question

class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));

        int res =1;
        int prev = 0;

        for(int curr =1 ; curr < points.length; curr++){
            if(points[curr][0] > points[prev][1]){
                res++;
                prev = curr;
            }
        }
        return res;

    }
}

// TC: O(nlogn)
// SC: O(1)

class Solution {
    public int findMinArrowShots(int[][] points) {
        //using Heap
        int res = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        for(int[] p : points){
            pq.add(p);
        }

        if(pq.isEmpty()){
            return 0;
        }

        while(!pq.isEmpty()){
            int[] prev = pq.poll();

            while(!pq.isEmpty()  && prev[1] >= pq.peek()[0] && prev[1] <= pq.peek()[1]){
                pq.poll();
            }
            res++;
        }
        return  res;
    }
}

// TC: O(nlogn)
// SC: O(n)

