class Solution {
    public int rob(int[] nums) {
        //using dp array
        if(nums.length == 0 || nums == null){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i < nums.length; i++){
            rob[i] = Math.max(rob[i-1],nums[i]+ rob[i-2]);
        }
        return rob[nums.length-1];
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public int rob(int[] nums) {
        //dp without using extra array

        if(nums.length  == 0 || nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i =2; i < nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i]);
        }
        return nums[nums.length-1];
    }
}

// TC: O(n)
// SC: O(1)

