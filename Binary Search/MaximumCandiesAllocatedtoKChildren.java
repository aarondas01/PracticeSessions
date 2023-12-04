class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 0, end = 0, mid = 0;
        for (int candy : candies)
            end = Math.max(end, candy);
        while (start < end) {
            mid = start + (end-start+1) / 2;
            long children = 0;
            for (int candy : candies)
                children += candy / mid;
            if (children >= k)
                start = mid;
            else
                end = mid-1;
        }
        return start;
    }
}
// TC: O(nlogn)
// SC: O(1)

class Solution {
    public int maximumCandies(int[] candies, long k) {
        //range based binary search
        int start = 1 , end = 0;

        for(int c: candies){
            end = Math.max(end,c);
        }
        int ans = start;

        while(start < end){
            int mid = start + (end-start)/2;
            if(canAllocateCandies(candies, mid,k)){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        // end case statisfies value or not
        return canAllocateCandies(candies,start,k) ? start  : start-1;
    }

    private boolean canAllocateCandies(int[] candies, int mid, long k){
        if(mid == 0){
            return true;
        }
        long countChild = 0;
        for(int c: candies){
            countChild += c/mid;

            if(countChild >= k){
                return true;
            }
        }
        return false;
    }
}

// TC: O(nlogn)
// SC: O(1)