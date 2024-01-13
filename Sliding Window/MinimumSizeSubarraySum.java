
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0 , window = Integer.MAX_VALUE;

        int start = 0, end  = 0;
        for(end  = 0; end < nums.length; end++){
            currSum += nums[end];
            while(currSum >= target){
                window = Math.min(window, end-start+1);
                currSum -= nums[start];
                start++;
            }
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //using binary search for O(nlogn)
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;

        int[] sum = new int[n+1];
        sum[0] = 0;

        for(int i =1; i <=n ; i++){
            sum[i] = sum[i-1]+ nums[i-1];
        }
        for(int i = 0 ; i < n ; i++){
            int val = target + sum[i];
            int border = binarySearch(sum, 0, n,val);
            if(border > 0){
                res = Math.min(res,border-i);
            }
        }
        return (res!=Integer.MAX_VALUE?res:0);
    }

    private int binarySearch(int[] sum , int start , int end, int target){
        while(start< end){
            int mid = start + (end-start)/2;
            if(sum[mid] >= target){
                end = mid;
            }
            else{
                start = mid+1;
            }

        }
        if(end == sum.length-1 && sum[end] < target){
            return -1;
        }
        return end;
    }
}

// TC: O(nlogn)
// SC: O(n)