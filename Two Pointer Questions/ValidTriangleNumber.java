class Solution {
    public int triangleNumber(int[] nums) {
        //two pointer
        Arrays.sort(nums);
        int count = 0;
        for(int i=2; i < nums.length; i++){
            int left = 0 ;
            int right = i-1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += right-left;
                    right--;
                }
                else{
                    left++;
                }

            }
        }
        return count;
    }
}
// TC: O(n^2)
// SC: O(1)