class Solution {
    public int mySqrt(int x) {
        //using binary search
        if(x == 0){
            return 0;
        }

        int low =1 , high = x;
        int ans  = 0;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(x/mid == mid){
                return mid;
            }
            else if( x/mid < mid){
                high = mid-1;
            }
            else{
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}

// TC: O(logn)
// SC: O(1)

class Solution {
    public int mySqrt(int x) {
        //Newton Method
        long res =x;
        while(res*res >x){
            res =(res+x/res)/2;
        }
        return (int) res;
    }
}