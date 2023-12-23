class MedianFinder {

    //priorityQueue

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)-> (b-a));
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return ((maxHeap.peek() + minHeap.peek())/2.0);
        }
        else{
            return maxHeap.peek();
        }
    }
}


//  TC: O(nlogk)
//  SC: O(n)