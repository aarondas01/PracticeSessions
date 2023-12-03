Kth Smallest Number in Multiplication Table

class Solution {
    public int findKthNumber(int m, int n, int k) {
        //modified binary search

        int start =1 , end = m*n;

        while(start < end){
            int mid = start + (end-start)/2;
            //rank of the element
            int ele = count(mid, m,n);
            if(ele < k){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    //rank of the element
    private int count(int mid, int m ,int n){
        int count  = 0;
        for(int i=1; i <=m; i++){
            int temp = Math.min(mid/i,n);
            count += temp;
        }
        return count;
    }
}

// TC: O(logn)
// SC: O(1)