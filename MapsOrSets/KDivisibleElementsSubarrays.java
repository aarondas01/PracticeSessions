class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        //using HashSet
        //create all subsarrays that satisfy the condition nums[i] % p ==0
        //add the subarray to set(removes duplicates)
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            int count  = 0;
            StringBuilder str = new StringBuilder();
            for(int j = i ; j < nums.length; j++){
                if(nums[j] % p == 0){
                    count++;
                }
                //if count > k that subarray is not required
                if(count > k){
                    break;
                }
                str.append(nums[j]+ " ");
                set.add(str.toString());
            }
        }
        return set.size();
    }
}

// TC: O(n^2)
// SC: O(n^2)