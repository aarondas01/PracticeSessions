class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute Force not recommended
        for(int i =0 ;  i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }
}

//TC: O(n^2)
//SC: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}

// TC: O(n)
// SC: O(n/)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        //using HashSet

        Set<Integer> set = new HashSet<>();

        int i;
        for( i =0 ; i < nums.length; i++){
            if(set.contains(target-nums[i])){
                break;
            }
            set.add(nums[i]);
        }

        for(int j = 0 ; j < i; j++){
            if(nums[j] == target-nums[i]){
                return new int[]{i,j};
            }
        }
        return new int[]{};
    }
}

// TC: O(n)
// SC: O(n)