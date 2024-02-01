class MedianFinder {

    //using Heap
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()  || maxHeap.peek()> num){
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }

        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return ((minHeap.peek() + maxHeap.peek())/2.0);
        }
        else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

//  TC: O(nlogn)
//  sc:o(n)