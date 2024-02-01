class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : nums){
            pq.add(n);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.poll();
    }
}

// TC : O(nlogK)
// SC: O(1)


class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

// TC: O(nlogn)
// SC: O(1)