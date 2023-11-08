class Solution {
    public int minKBitFlips(int[] nums, int k) {
        //using dp
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);


        int curr = 0 , ans =0;

        for(int i = 0 ; i < n ; i++){
            if((nums[i]+ dp[i] + curr)%2 == 0 ){
                ans++;
                if(i+k < n){
                    dp[i+k] = -1;
                }
                else if(i+k > n){
                    return -1;
                }
                curr += dp[i] +1;
            }
            else{
                curr += dp[i];
            }
        }
        return ans;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int res = 0, start = 0;

        for(int i = 0 ; i < n ; i++){
            if(i >= k && nums[i-k] > 1){
                start ^= 1;
            }
            if(nums[i] == start){
                if(i+k > n){
                    return -1;
                }
                res++;
                start ^= 1;
                nums[i] +=2;
            }
        }
        return res;
    }
}

// TC: O(n)
// SC: O(1)