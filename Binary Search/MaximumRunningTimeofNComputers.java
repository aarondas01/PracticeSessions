class Solution {
    public long maxRunTime(int n, int[] batteries) {
        //find the lower bound the lowest value
        //find the higher bound = totalsum/n +1

        //apply binary search
        long low = 0;
        long totalSum = 0;
        for(int b : batteries){
            low = Math.min(low,b);
            totalSum += b;
        }
        // +1 beacuse high value is included
        long high = (totalSum/n)+1;

        long res = -1;
        while(low < high){
            long mid = low + (high-low)/2;

            if(calc(n,mid,batteries)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return res;
    }

    private boolean calc(int n, long timespan, int[] batteries){
        long currSum = 0 ;

        long targetSum = n * timespan;

        for(int b : batteries){
            if(b < timespan){
                currSum += b;
            }
            else{
                currSum += timespan;
            }
            if(currSum >= targetSum){
                return true;
            }
        }
        return currSum >= targetSum;
    }
}

// TC: O(logn)
// SC: O(1)