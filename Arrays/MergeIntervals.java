class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if(intervals == null || intervals.length ==0){
            return list.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a,b)-> (a[0]-b[0]));

        int start = intervals[0][0];
        int end  = intervals[0][1];

        for(int[] interval : intervals){
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}

// TC: O(nlogn)
// SC: O(n)


class Solution {
    public int[][] merge(int[][] intervals) {
        //using minHeap

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        List<int[]> list = new ArrayList<>();

        for(int[] interval : intervals){
            pq.offer(interval);
        }

        while(!pq.isEmpty()){
            int[] peak = pq.poll();

            while(!pq.isEmpty()  && pq.peek()[0] <= peak[1]){
                peak[1] = Math.max(peak[1], pq.poll()[1]);
            }
            list.add(peak);
        }

        return list.toArray(new int[list.size()][]);

    }
}

// TC: O(nlogn)
// SC: O(n)