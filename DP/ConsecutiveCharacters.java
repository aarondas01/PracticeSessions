
Consecutive Characters

class Solution {
    public int maxPower(String s) {
        int maxCount  = 1, count = 1;
        for(int i = 0 ; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
                maxCount = Math.max(maxCount,count);
            }
            else{
                count = 1;
            }

        }
        return maxCount;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int maxPower(String s) {
        //using dp

        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max =1;
        for(int i=1; i< s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                dp[i] = dp[i-1]+1;
                max = Math.max(max,dp[i]);
            }
            else{
                dp[i] = 1;
            }
        }
        return max;
    }
}

// TC: O(n)
// SC: O(n)