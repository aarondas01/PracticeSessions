class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp bottom up

        if(triangle.size() ==1){
            return triangle.get(0).get(0);
        }

        int k = triangle.size();
        int[] dp = new int[k+1];

        for(int i = k-1 ; i >= 0 ; i--){
            int m = triangle.get(i).size();
            for(int j = 0; j < m ; j++){
                dp[j]= Math.min(dp[j],dp[j+1])  + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}

// TC: O(n^2)
// SC: O(n)


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp top down approach

        int height = triangle.size();
        int[][] dp = new int[height+1][height+1];

        for(int i = height-1; i >=0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}

// TC: O(n^2)
// SC: O(n^2)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //changes the original array
        for(int i = triangle.size()-2; i >= 0; i--){
            for(int j = 0 ; j <triangle.get(i).size(); j++){
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int sum = min + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }
}

// TC: O(n^2)
// SC: O(1)