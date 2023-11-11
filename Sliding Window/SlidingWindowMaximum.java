class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //using Deque

        //new element comes, make space for it
        //remove smaller elements  in the window
        //push i in deque for nums[i]
        // i >= k-1 then add the element to the answer
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int r = 0;

        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() && deque.peek() == i-k){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k-1){
                res[r++] = nums[deque.peek()];
            }
        }
        return res;

    }
}

// TC: O(n)
// SC: O(k)


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //using TreeMap
        //  bcoz TreeMap is sorted order
        //  getting max is O(1)
        //  getting an element in Treemap is nlogn
        //  removing an element in TreeMap is nlogn
        // <Number, Frequency>
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        int n = nums.length;
        int[] ans = new int[n-k+1];
        int j  =0 ;
        for(int i = 0 ; i < n; i++ ){
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i],0)+1);

            if(i >= k-1){
                ans[j] = treeMap.lastKey();
                j++;

                //delete the first element of the window
                //i-k+1
                treeMap.put(nums[i-k+1], treeMap.get(nums[i-k+1])-1);

                //if frequency is 0 remove the element from treeMap
                if(treeMap.get(nums[i-k+1])==0){
                    treeMap.remove(nums[i-k+1]);
                }
            }
        }
        return ans;
    }
}
// TC: O(nlogk)
// SC: O(n-k)
