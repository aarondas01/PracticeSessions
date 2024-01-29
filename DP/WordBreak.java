class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //backtracking and memoization

        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String,Boolean> map = new HashMap<>();

        return backtrack(s,map,wordSet);

    }


    private boolean backtrack(String s, Map<String,Boolean> map, Set<String> wordSet){
        if(map.containsKey(s)){
            return map.get(s);
        }

        if(wordSet.contains(s)){
            return true;
        }

        for(int i =1; i< s.length(); i++){
            String prefix = s.substring(0,i);
            if(wordSet.contains(prefix) && backtrack(s.substring(i), map, wordSet)){
                map.put(s,true);
                return true;
            }
        }

        map.put(s,false);
        return false;
    }
}

// TC: O(n*m + k)
// SC: O(n+k)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp tabulation

        Boolean[] dp = new Boolean[s.length()];

        return helper(0,s, wordDict,dp);
    }

    private boolean helper(int index, String s, List<String> wordDict, Boolean[] dp ){

        int n = s.length();
        if(index == n){
            return true;
        }

        if(dp[index] != null){
            return dp[index];
        }


        for(int i = index; i <= n; i++){
            if(wordDict.contains(s.substring(index,i)) && helper(i,s,wordDict,dp)){
                return dp[index] = true;
            }
        }

        return  dp[index] = false;
    }
}

// TC: O(n^2)
// SC: O(n)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp

        int n = s.length();
        boolean[] dp = new boolean[n];

        for(int k = 0 ; k < n ; k++){
            for(int j = 0 ; j<= k; j++){
                if((j==0 || dp[j-1] == true)  && wordDict.contains(s.substring(j,k+1))){
                    dp[k] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}

// TC: O(n^2)
// SC: O(n)