class Solution {
    public long appealSum(String s) {
        // dp
        //f(i) = f(i-1) + i - lastIndex(character)

        int n = s.length();
        long[] dp = new long[n+1];

        //last index(occurence) of each character
        int[] lastIndex = new int[26];

        Arrays.fill(lastIndex,-1);

        long res = 0l;

        for(int i = 0 ; i < n ; i++){
            int c  = s.charAt(i) - 'a';
            dp[i+1] = dp[i] + i - lastIndex[c];
            res += dp[i+1];

            lastIndex[c] = i;
        }
        return res;

    }
}

// TC: O(n)

