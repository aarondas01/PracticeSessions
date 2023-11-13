class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int start = bottom;
        int end = top;
        int ans = 0;

        for(int i = 0 ; i < special.length; i++){
            int specialIndex =  special[i];
            int diff = specialIndex - start;
            ans = Math.max(ans,diff);
            start = specialIndex +1;
        }
        ans = Math.max(ans, end - special[special.length-1]);
        return ans;
    }
}

// TC: O(nlogn)
// SC: O(1)