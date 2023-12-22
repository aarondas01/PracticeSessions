class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //using minHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        for(int i = 0 ; i < nums.length; i++){
            pq.offer(new int[]{nums[i],i});
            if(pq.size()>k){
                pq.poll();
            }
        }

        Set<Integer> set = new HashSet<>();

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            set.add(top[1]);
        }

        int[] res = new int[k];
        int p = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(set.contains(i)){
                res[p] = nums[i];
                p++;
            }
        }
        return res;


    }
}

// TC: O(nlogk)
// SC: O(n)