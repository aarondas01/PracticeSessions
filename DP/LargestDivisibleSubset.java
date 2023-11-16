class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //similar to LIS
        //find LIS where current element is divisible by previous element

        //sort the array
        //find LIS apply dp similar to LIS
        //find subset

        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        if(n==0){
            return result;
        }

        //sort the array
        Arrays.sort(nums);

        int max =1;

        //apply dp similar to LIS
        int[] dp = new int[n+1];

        //minimum divisible subset will have one element, the element itself
        Arrays.fill(dp,1);

        for(int i=1; i <n; i++){
            for(int j =0 ; j <i ; j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = dp[j] +1;
                    max = Math.max(max,dp[i]);
                }
            }
        }

        int prev = -1;

        // find subset from right to left

        for(int i = n-1; i >= 0 ; i--){
            //prev =-1 for first element
            if(dp[i] == max && (prev %nums[i] == 0 || prev ==-1)){
                result.add(nums[i]);
                max--;
                prev = nums[i];
            }
        }
        return result;
    }
}
// TC: O(n^2)
// SC: O(n)