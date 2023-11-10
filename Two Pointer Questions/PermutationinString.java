class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //using two pointers
        int[] charFreq = new int[26];

        int len = s1.length();
        for(char c: s1.toCharArray()){
            charFreq[c-'a']++;
        }

        int i = 0 , j = 0;
        while(j < s2.length()){
            if(charFreq[s2.charAt(j++)- 'a']-- > 0){
                len--;
            }
            if(len == 0){
                return true;
            }
            if(j-i == s1.length() && charFreq[s2.charAt(i++)-'a']++ >= 0){
                len++;
            }
        }
        return false;
    }
}
// TC: O(n)
// SC: O(1)