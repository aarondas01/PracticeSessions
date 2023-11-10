class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using Map
        HashMap<Character,Integer> map = new HashMap<>();

        int start = 0 , maxLen  = 0;
        int n = s.length();

        if(n<=1){
            return n;
        }
        for(int end  = 0 ; end < n ; end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }
            map.put(c,end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
// TC: O(n)
// SC: O(n)


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window

        int[] index = new int[128];
        int n = s.length();
        int left = 0, maxLen =0;

        for(int  right  = 0; right < n ; right++){
            left = Math.max(left, index[s.charAt(right)]);
            maxLen = Math.max(maxLen, right-left+1);
            index[s.charAt(right)] = right+1;
        }
        return maxLen;
    }
}
// TC: O(n)
// SC: O(1)


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using Set

        Set<Character> set = new HashSet<>();
        int left = 0 , right  = 0, maxLen = 0;
        int n = s.length();
        while(left < n && right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                maxLen = Math.max(maxLen, right-left);
            }
            else{
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }
}
// TC: O(n)
// SC: O(n)