class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //sliding window

        int n = cardPoints.length;
        int  left = 0 , right = cardPoints.length - k;

        int currSum = 0;
        for(int i = right ; i < n ; i++){
            currSum += cardPoints[i];
        }

        int maxSum = currSum;

        while(right < n){
            currSum += (cardPoints[left++]-cardPoints[right++]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
// TC: O(k)
// SC: O(1)

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int currSum = 0;
        int n =cardPoints.length;
        for(int i =0; i < k; i++){
            currSum += cardPoints[i];
        }
        int maxSum = currSum;
        int right = 0;
        while(right < k){
            currSum = currSum - cardPoints[k-right-1] + cardPoints[n-1-right];
            maxSum = Math.max(maxSum,currSum);
            right++;
        }
        return maxSum;
    }
}
// TC: O(k)
// SC: O(1)