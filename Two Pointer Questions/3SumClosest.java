class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //two pointer
        int closest = Integer.MAX_VALUE;
        int n  = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i < n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left< right){
                int sum = nums[i]+ nums[left]+ nums[right];
                if(Math.abs(target-closest)> Math.abs(target-sum)){
                    closest = sum;
                }
                if(sum < target){
                    left++;
                }
                else {
                    right--;
                }
            }

        }
        return closest;
    }
}
// TC: O(n^2)
// SC: O(1)


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0 ; i< n ;i++){
            for(int j = i+1; j < n ;j++){
                for(int k = j+1 ; k <n ;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target-closest)> Math.abs(target-sum)){
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}
// TC: O(n^3)
// SC: O(1)