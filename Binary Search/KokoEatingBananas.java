class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //binary search
        int low = 1, high =1;
        for(int pile: piles){
            high = Math.max(pile,high);
        }

        while(low < high){
            int k = low + (high-low)/2;
            int hrs = 0;
            for(int p : piles){
                hrs += Math.ceil((double)p/k);
            }
            if(hrs <= h){
                high = k;
            }
            else{
                low = k+1;
            }
        }
        return high;
    }
}

// TC: O(logn)
// SC: O(1)