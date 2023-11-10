K-diff Pairs in an Array


class Solution {
    public int findPairs(int[] nums, int k) {
        //using HashMap
        Map<Integer,Integer> map = new HashMap<>();
        int count  =0 ;

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int i : map.keySet()){
            if(k >0 && map.containsKey(i+k) || k == 0 && map.get(i)>1){
                count++;
            }
        }
        return count;
    }
}
// TC: O(n)
// SC: O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        //using binary Search

        Arrays.sort(nums);
        int i = 0 ,  j =1;
        int count  = 0;

        while(i < nums.length && j < nums.length){
            if(nums[j]- nums[i] == k){
                count++;
                i++;
                j++;
                //remove duplicates
                while(j < nums.length && nums[j] == nums[j-1]){
                    j++;
                }
            }
            else if( nums[j] - nums[i] > k){
                i++;
                //duplicate
                if(j-i==0){
                    j++;
                }
            }
            else{
                j++;
            }
        }
        return count;
    }
}
// TC: O(nlogn)
// SC: O(1)