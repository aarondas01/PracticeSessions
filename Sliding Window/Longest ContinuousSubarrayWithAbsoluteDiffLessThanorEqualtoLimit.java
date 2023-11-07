class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //using Deque

        if(nums == null || nums.length == 0)
            return 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();


        int maxLen = 0 ;
        int left = 0;

        for(int i = 0 ; i < nums.length; i++){
            while(!maxDeque.isEmpty() && maxDeque.peekLast()< nums[i]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[i]);

            while(!minDeque.isEmpty() && minDeque.peekLast()> nums[i]){
                minDeque.pollLast();
            }
            minDeque.addLast(nums[i]);

            while(Math.abs(maxDeque.peekFirst() - minDeque.peekFirst())> limit){
                if(maxDeque.peekFirst() == nums[left]){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst() == nums[left]){
                    minDeque.pollFirst();
                }
                left++;
            }
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;

    }
}

// TC: O(n)
// SC: O(n)