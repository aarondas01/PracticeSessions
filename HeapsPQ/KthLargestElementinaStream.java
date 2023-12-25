
class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap ;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.add(n);
        }

    }

    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

al);
 *//**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(v

//  TC: O(nlogk)
//  SC: O(n)