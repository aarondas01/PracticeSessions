class Solution {
    public int majorityElement(int[] nums) {
        //Moore's voting algorithm
        int votes = 1;
        int major  = nums[0];
        for(int n : nums){
            if(n == major){
                votes++;
            }
            else{
                votes--;
            }
            if(votes == 0){
                major = n;
                votes =1;
            }
        }
        return major;

    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public int majorityElement(int[] nums) {
        //using HashMap
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }
            else{
                map.put(n, map.get(n)+1);
            }
            if(map.get(n) > nums.length/2){
                return n;
            }
        }
        return max;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public int majorityElement(int[] nums) {
        //sorting
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
// TC: O(nlogn)
// SC: O(1)