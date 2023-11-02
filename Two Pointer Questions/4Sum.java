class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //two pointer
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i < n; i++){
            //to remove duplicates
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j< n; j++){
                //to remove duplicates
                if(j> i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = n-1;

                while(left < right){
                    long sum = nums[i];
                    sum+= nums[j];
                    sum+= nums[left];
                    sum+= nums[right];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j] , nums[left] , nums[right]));

                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right]== nums[right+1]){
                            right--;
                        }
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }

                }
            }
        }
        return res;
    }
}
// TC: O(n^2)
// SC: O(1)