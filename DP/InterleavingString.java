class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //TOP down DP

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        Boolean[][] match = new Boolean[s1.length()+1][s2.length()+1];

        return helper(s1, s2, s3 ,0, 0 ,match);
    }

    private boolean helper(String s1, String s2, String s3, int i , int j, Boolean[][] match){
        if(i > s1.length() || j > s2.length()){
            return false;
        }
        if(match[i][j] != null){
            return match[i][j];
        }

        if( i == s1.length() && j == s2.length()){
            match[i][j] = i+j == s3.length();
            return match[i][j];
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && helper(s1, s2, s3,i+1,j ,match)){
            match[i][j] = true;
            return true;
        }

        if( j < s2.length()  &&  s2.charAt(j) == s3.charAt(i+j)  && helper(s1, s2, s3, i, j+1, match)){
            match[i][j] = true;
            return true;
        }
        else{
            match[i][j] = false;
            return false;
        }
    }
}

// TC: O(m*n)
// SC: O(m*n)