class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String s : strs){
            int ones = 0 , zeros =0;
            for(char c : s.toCharArray()){
                if(c=='0'){
                    zeros++;
                }
                else{
                    ones++;
                }
            }

            for(int i = m ; i >=zeros ;i--){
                for(int j = n ; j >= ones ; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}

// TC: O(m*n*lenOfstrs)
// SC: O(m*n)


class Solution {
    int[][][] dp = null;
    public int findMaxForm(String[] strs, int m, int n) {
        //using memoization
        dp = new int[m+1][n+1][strs.length];

        int[][] strFreq = new int[strs.length][2];
        int i = 0;
        for(String s : strs){
            strFreq[i] = countFreq(s);
            i++;
        }
        return helper(strs,m ,n , 0 , strFreq);
    }

    private int helper(String[] strs, int m , int n,int index, int[][] strFreq){
        if(index >= strs.length || m+n <=0){
            return 0;
        }

        if(dp[m][n][index]>0){
            return dp[m][n][index];
        }

        int countCurrentIncl = 0 ;
        int countCurrentExcl = 0;

        int zeros = strFreq[index][0];
        int ones = strFreq[index][1];

        if(m >= zeros && n >= ones){
            countCurrentIncl = 1 + helper(strs,m-zeros,n-ones, index+1,strFreq);
        }
        countCurrentExcl = helper(strs,m,n, index+1, strFreq);

        dp[m][n][index] = Math.max(countCurrentIncl,countCurrentExcl);
        return dp[m][n][index];
    }

    private int[] countFreq(String s){
        int[] freq = new int[2];
        for(char c : s.toCharArray()){
            if(c== '0'){
                freq[0]++;
            }else{
                freq[1]++;
            }
        }
        return freq;
    }
}

// TC: O(m*n*lengthofstrs)
// SC: O(m*n)
