class Solution {
    public int countTexts(String pressedKeys) {
        //dp

        int mod = 1000000007;
        int n = pressedKeys.length();

        long[] dp = new long[n+1];
        dp[n] = 1;

        for(int i = n-1; i >= 0; i--){
            dp[i] = dp[i+1];
            if(isSame(pressedKeys,i,2)){
                dp[i] += dp[i+2];
            }
            if(isSame(pressedKeys,i,3)){
                dp[i] += dp[i+3];
            }
            if((pressedKeys.charAt(i) == '7' || pressedKeys.charAt(i) == '9') && isSame(pressedKeys,i,4)){
                dp[i] += dp[i+4];
            }
            dp[i] %= mod;
        }
        return (int)dp[0];
    }

    private boolean isSame(String pressedKeys, int i, int k){
        if(i+k > pressedKeys.length()){
            return false;
        }
        for(int j = i +1 ; j < i+k ; j++){
            if(pressedKeys.charAt(j) != pressedKeys.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
// TC: O(n)
// SC: O(n)