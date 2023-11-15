class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        if(n==1){
            return questions[0][0];
        }

        long[] dp = new long[200001];
        dp[0] = 1l;

        //dp[i] is maxPoints gained by questions from  i to n-1
        // dp[0] = 0 to n-1

        for(int i = n-1; i >= 0 ; i--){
            dp[i] = Math.max(questions[i][0] + dp[i + questions[i][1]+1],dp[i+1]);
        }
        return dp[0];
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        if(n==1){
            return questions[0][0];
        }

        long[] dp = new long[n];

        for(int i= n-1; i >=0 ;i--){

            int nextQuestionsIndex =i + questions[i][1] +1;
            if(nextQuestionsIndex < questions.length){
                dp[i] = dp[nextQuestionsIndex] + questions[i][0];
            }
            else{
                dp[i] = questions[i][0];
            }

            if(i < questions.length -1){
                dp[i] = Math.max(dp[i],dp[i+1]);
            }
        }
        return dp[0];
    }
}
// TC: O(n)
// SC: O(n)