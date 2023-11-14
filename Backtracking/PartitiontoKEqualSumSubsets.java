class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum  = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum %k != 0){
            return false;
        }

        if(nums.length < k){
            return false;
        }

        //sum of each part
        int subsetSum = sum/k;

        boolean[] visited = new boolean[nums.length];


        return backtrack(nums,visited,0,k,0,subsetSum);
    }

    private boolean backtrack(int[] nums,boolean[] visited, int index, int k, int currentSum, int subsetSum){

        if(k==0){
            return true;
        }
        if(k==1){
            return true;
        }
        if(currentSum > subsetSum || k > nums.length){
            return false;
        }
        if(currentSum == subsetSum){
            return backtrack(nums,visited,0,k-1,0,subsetSum);
        }

        for(int i = index; i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(backtrack(nums,visited,i+1,k,currentSum + nums[i],subsetSum)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
// TC: O(n^2^n)
// SC: O(n)

