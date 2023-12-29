class Solution {
    public int largestCombination(int[] candidates) {
        int[] binarySetCount = new int[32];

        for(int i = 0; i < binarySetCount.length; i++){
            for(int c : candidates){
                if(((c >>i) &1) ==1){
                    binarySetCount[i]++;
                }
            }
        }
        int res  = 0;
        for(int n : binarySetCount){
            res = Math.max(res,n);
        }
        return res;
    }
}

// TC: O(32* len(candidates))
// sC: O(1)