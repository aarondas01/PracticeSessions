class Solution {
    public int countBinarySubstrings(String s) {
        int count =0, index =1, prev =0 , curr =1;

        while(index < s.length()){
            if(s.charAt(index-1) != s.charAt(index)){
                count += Math.min(prev,curr);
                prev = curr;
                curr =1;
            }
            else{
                curr++;
            }
            index++;
        }
        return count += Math.min(prev,curr);
    }
}

// TC: O(n)
// SC: O(1)