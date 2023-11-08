class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //sliding window with Map

        int n = nums.length;
        int i = 0 , j = 0;

        int count = 0 , ans = 0 , prefix =0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(j < n){
            if(map.containsKey(nums[j])){
                map.put(nums[j], map.get(nums[j])+1);
            }
            else{
                map.put(nums[j],1);
            }

            if(map.get(nums[j]) == 1){
                count++;
            }
            j++;

            if(count > k){
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i])-1);
                }
                else{
                    map.put(nums[i], -1);
                }
                i++;
                count--;
                prefix = 0;
            }

            while(map.get(nums[i])>1){
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i])-1);
                }
                else{
                    map.put(nums[i],-1);
                }
                i++;
                prefix++;
            }
            if(count == k){
                ans += prefix+1;
            }
        }
        return ans;
    }
}
// TC: O(n)
// SC: O(n)