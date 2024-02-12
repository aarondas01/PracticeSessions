class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //brute force

        for(int i = 0 ; i < nums.length; i++){
            for(int j = i+1; j < nums.length && j <= (i+k); j++){
                if(nums[i]== nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

// TC: O(n^2)
// SC: O(1)


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //using HashMap

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<= k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}

// TC: O(n)
// SC: O(n)