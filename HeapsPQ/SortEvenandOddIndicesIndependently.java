class Solution {
    public int[] sortEvenOdd(int[] nums) {
        //using minHeap and maxHeap
        //use maxHeap for odd index elements(reverse)
        //use minHeap for even index elements(reverse)

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> (b-a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> (a-b));


        for(int i = 0 ; i < nums.length; i+=2){
            minHeap.offer(nums[i]);
        }

        for(int i =1; i < nums.length; i+=2){
            maxHeap.offer(nums[i]);
        }

        int k = 0;
        while(!minHeap.isEmpty()){
            nums[k] = minHeap.poll();
            k+=2;
        }

        k =1;
        while(!maxHeap.isEmpty()){
            nums[k] = maxHeap.poll();
            k+=2;
        }
        return nums;

    }
}

// TC: O(nlogn)
// SC: O(n)