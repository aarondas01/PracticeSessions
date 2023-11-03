Longest Harmonious Subsequence

class Solution {
    public int findLHS(int[] nums) {
        //using Map
        int result  = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(int i : map.keySet()){
            if(map.containsKey(i+1)){
                result = Math.max(result,map.get(i)+map.get(i+1));
            }
        }
        return result;
    }
}
// TC: O(n)
// SC: O(n)

class Solution {
    public int findLHS(int[] nums) {
        //sorting
        Arrays.sort(nums);
        int left = 0 , right = 1;
        int count  =0;
        while(right < nums.length){
            int diff = nums[right]- nums[left];
            if(diff==1){
                count = Math.max(count, right-left +1);
            }
            if(diff <=1){
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
}
// TC: O(nlogn)
// SC: O(1)