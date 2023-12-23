class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // ladder has adjustable height(use for larger height)
        // bricks have height of 1 unit(use for shorter height)

        //use the ladder first to climber greater heights
        //store the k highest climbs in a PQ where k is ladders


        //if you found the height to climb is greater than one of the heights in
        // k highest climbs, swap the bricks with the ladder for greater heights

        //min Heap

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < heights.length-1; i++){
            int diff = heights[i+1]- heights[i];
            if(diff > 0){
                pq.offer(diff);
            }

            //if ladders are not enough use the bricks
            if(pq.size()> ladders){
                bricks -= pq.poll();
            }

            if(bricks < 0){
                return i;
            }
        }
        return heights.length-1;
    }
}

// TC: O(nlogn)
// SC: O(ladders)

