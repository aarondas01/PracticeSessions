class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp using memoization

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int ans  =1;

        for(int i=0; i < nums.length; i++){
            for(int j = 0 ; j<i ; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}

// TC: O(n^2)
// SC: O(n)


class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp uisng binary search
        int[] dp =new int[nums.length];

        int k = 0;
        dp[k] = nums[0];
        for(int i=1; i < nums.length; i++){
            if(nums[i]< dp[k]){
                int start = 0;
                int end = k;
                while(start <= end){
                    int mid = (start + end)/2;
                    if(dp[mid] < nums[i]){
                        start = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
                dp[start] = nums[i];
            }
            else if(nums[i] != dp[k]){
                k++;
                dp[k] = nums[i];
            }
        }
        return k+1;
    }
}

// TC: O(nlogn)
// SC: O(n)

