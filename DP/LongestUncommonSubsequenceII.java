class Solution {
    public int findLUSlength(String[] strs) {
        //check if the strings are subsequence or not
        //check the length

        int res  =-1;
        for(int i = 0 ; i < strs.length ; i++){
            boolean sts = false;
            for(int j = 0; j < strs.length; j++){
                if(i != j && isSubsequence(strs[i],strs[j])){
                    sts = true;
                    break;
                }
            }
            if(!sts){
                res = Math.max(res,strs[i].length());
            }

        }
        return res;

    }
    private boolean isSubsequence(String s1, String s2){
        int i = 0 , j = 0;
        while(i < s1.length()  && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j++)){
                i++;
            }
        }
        return i == s1.length();
    }


}

// TC: O(n^2)
// SC: O(1)