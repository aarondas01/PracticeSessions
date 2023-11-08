static String minWindow(String str1, String str2) {
        // code here

        //using DP
        int m = str2.length();
        int n = str1.length();

        int[][] dp = new int[m+1][n+1];

        for(int j =0; j <= n ; j++){
        dp[0][j] = j;
        }

        for(int i =1 ; i <= m ; i++){
        dp[i][0] = -1;
        for(int j = 1; j <= n ; j++){
        if(str1.charAt(j-1) == str2.charAt(i-1) ){
        dp[i][j] = dp[i-1][j-1];
        }
        else{
        dp[i][j] = dp[i][j-1];
        }

        }
        }
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        for(int j =1; j <= n ; j++){
        if(dp[m][j] != -1){
        if(j-dp[m][j] +1 < minLen){
        minLen = j - dp[m][j] +1;
        start = dp[m][j];
        end = j;
        }
        }
        }
        return minLen == Integer.MAX_VALUE? "" : str1.substring(start,end);
        }
        }

// TC: O(m*n) O(n^2)
// SC: O(m*n) O(n^2)