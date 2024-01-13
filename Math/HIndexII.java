class Solution {
    public int hIndex(int[] citations) {
        //binary search

        int len = citations.length;
        int start = 0 , end = len-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(citations[mid] == len -mid){
                return len-mid;
            }
            else if(citations[mid] < len-mid){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return len-start;
    }
}

// TC: O(logn)
// sc: O(1)

