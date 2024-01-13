class Solution {
    public int hIndex(int[] citations) {
        //given array is unsorted
        //using sorting and binary search

        Arrays.sort(citations);
        int n = citations.length;

        int start = 0 , end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int value = citations[mid];
            int pos = n-mid;
            if(value >= pos){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return n-end-1;
    }
}

// TC: O(nlogn)
// SC: O(1)


class Solution {
    public int hIndex(int[] citations) {
        //using buckets
        int len = citations.length;
        int[] bucket = new int[len+1];

        for(int c : citations){
            if(c>= len){
                bucket[len]++;
            }
            else{
                bucket[c]++;
            }
        }
        int count  = 0 ;
        for(int i = len; i >= 0 ; i--){
            count += bucket[i];

            if(count >= i){
                return i;
            }
        }
        return 0;

    }
}
// TC: O(n)
// SC: O(n)