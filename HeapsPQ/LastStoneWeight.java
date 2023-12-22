class Solution {
    public int lastStoneWeight(int[] stones) {
        //using maxHeap

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> (b-a));

        for(int s : stones){
            maxHeap.offer(s);
        }


        while(maxHeap.size()>1){
            int largestStone = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            if(largestStone == secondLargest){
                continue;
            }
            else{
                int diff = largestStone- secondLargest;
                maxHeap.add(diff);
            }
        }
        return maxHeap.size() ==0 ? 0 : maxHeap.poll();
    }
}

// TC: O(nlogn)
// SC: O(n)

