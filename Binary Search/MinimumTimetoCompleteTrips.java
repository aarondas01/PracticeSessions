class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        //range based binary search
        long left = 1;
        long minTime =time[0];
        for(int t : time){
            minTime = Math.min(minTime,t);
        }
        long right = minTime*totalTrips;

        while(left < right){
            long mid = left + (right-left)/2;
            long tripCount = countTrips(time,mid);

            if(tripCount < totalTrips){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    private long countTrips(int[] time, long mid){
        long count= 0;
        for(int t : time){
            count +=(long)mid/t ;
        }
        return count;
    }
}

// TC: O(nlogn)
// SC: O(1)
