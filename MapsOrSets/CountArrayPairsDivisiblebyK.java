class Solution {
    public long countPairs(int[] nums, int k) {
        //find GCD of two numbers
        // Map<UniqueGCD, freq>

        Map<Integer,Integer> map = new HashMap<>();
        long ans = 0;

        for(int i = 0 ; i < nums.length; i++){
            int gcdNum1 = findGCD(nums[i],k);

            for(int gcdNum2 : map.keySet()){
                if((long)gcdNum1 * gcdNum2 % k == 0){
                    ans += map.get(gcdNum2);
                }
            }
            map.put(gcdNum1, map.getOrDefault(gcdNum1, 0)+1);
        }
        return ans;
    }

    private int findGCD(int x , int y){
        if(y > x){
            return findGCD(y,x);
        }
        return y == 0 ? x : findGCD(y,x%y);
    }
}
// TC: O(n)
// SC:O(n)