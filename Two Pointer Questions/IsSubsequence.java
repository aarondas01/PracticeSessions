class Solution {
    public boolean isSubsequence(String s, String t) {
        //two pointer
        if(s.isEmpty())
            return true;
        int i = 0  , j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}

// TC: O(n)
// SC: O(1)