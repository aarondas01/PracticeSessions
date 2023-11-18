class Solution {
    public boolean canJump(int[] nums) {
        //greedy
        int finalPos = nums.length -1;
        for(int i = nums.length -2; i >=0 ; i--){
            if(i+ nums[i] >= finalPos){
                finalPos = i;
            }
        }
        //if you can reach the final pos, the final pos will be at first index
        return finalPos == 0;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public boolean canJump(int[] nums) {
        int count  =1;
        for(int i = 0 ; i < nums.length ; i++){
            if(count <1){
                return false;
            }
            count = Math.max(count-1,nums[i]);
        }
        return true;
    }
}

// TC: O(n)
// SC: O(1)