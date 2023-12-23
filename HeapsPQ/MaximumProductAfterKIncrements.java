class Solution {
    public int maximumProduct(int[] nums, int k) {
        //using minHeap
        //keep on increasing then lowest value k times
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.offer(n);
        }

        while(k > 0){
            int element = pq.poll();
            element++;
            pq.offer(element);
            k--;
        }

        long prod =1;
        while(!pq.isEmpty()){
            prod = (prod*pq.poll())%1000000007;
        }

        return (int)(prod);
    }
}

// TC: O(nlogn)
// SC: O(n)