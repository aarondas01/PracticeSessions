class Solution {
    public int maxOperations(int[] nums, int k) {
        //two pointer apporach

        int left  = 0, right = nums.length -1;
        int count  = 0;
        Arrays.sort(nums);

        while(left< right){
            if(nums[left] + nums[right] == k){
                left++;
                right--;
                count++;
            }
            else if(nums[left] + nums[right] < k){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}

// TC: O(nlogn)
// SC: O(1)


class Solution {
    public int maxOperations(int[] nums, int k) {
        //using HashMap
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0 ;

        for(int n : nums){
            if(map.containsKey(n) && map.get(n) >0){
                map.put(n,map.get(n)-1);
                count++;
            }
            else{
                map.put(k-n,map.getOrDefault(k-n,0)+1);
            }
        }
        return count;
    }
}

// TC: O(n)
// SC: O(n)

