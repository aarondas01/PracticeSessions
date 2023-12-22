class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //using Heap

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));

        for(int[] pt : points){
            pq.add(pt);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int count =0;
        while(!pq.isEmpty()){
            res[count] = pq.poll();
            count++;
        }
        return res;
    }
}

// TC: O(nlogn)
// SC: O(k)


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(a,b)-> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];

            return distA-distB;
        });

        return Arrays.copyOfRange(points,0,k);
    }
}

// TC: O(nlogn)
// SC: O(1)