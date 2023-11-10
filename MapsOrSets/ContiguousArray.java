class Solution {
    public int findMaxLength(int[] nums) {
        //using HashMap

        //replace all 0s with -1
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for(int i= 0 ;i < nums.length; i++){
            sum += (nums[i] ==0 )? -1: nums[i];
            if(sum ==0){
                maxLength = i+1;
            }
            else if(map.containsKey(sum)){
                maxLength = Math.max(maxLength,i- map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}

// TC: O(n)
// SC: O(n)