class Solution {
    public int minimumCardPickup(int[] cards) {
        //find the last occurence of each element in the array
        //if element is found update the index as i
        //compare the min value with i - lastIndex[ele] +1
        int[] lastIndex = new int[1000001];
        Arrays.fill(lastIndex,-1);
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ;i < cards.length; i++){
            if(lastIndex[cards[i]] != -1){
                ans = Math.min(ans, i - lastIndex[cards[i]]+1);
            }
            lastIndex[cards[i]] = i;
        }
        return ans== Integer.MAX_VALUE ? -1 : ans;

    }
}

// TC: O(n)
// SC: O(1)