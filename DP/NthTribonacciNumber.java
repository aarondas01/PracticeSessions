class Solution {
    public int tribonacci(int n) {
        int first  = 0 , second  = 1 , third = 1, sum  = 0;
        if(n ==0 ){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        for(int i=3; i<=n ;i++){
            sum = first+second+third;
            first = second;
            second = third;
            third = sum;
        }
        return sum;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public int tribonacci(int n) {
        //using dp
        if(n==0)
            return 0;
        if(n==1 || n==2){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for(int i=3;i<= n ; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
// TC: O(n)
// SC: O(n)