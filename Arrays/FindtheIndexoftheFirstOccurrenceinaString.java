class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()  < needle.length()){
            return -1;
        }
        for(int i = 0 ; i <= haystack.length()- needle.length();i++){
            int j = 0;
            while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
                if(j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for(int i = 0 ; i <=m-n ;i++){
            for(int j  = 0; j <n; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == n-1){
                    return i;
                }
            }
        }
        return -1;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}