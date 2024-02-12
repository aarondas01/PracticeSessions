class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //using HashMap
        Map<Character,Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c)  || map.get(c) < 1){
                return false;
            }
            map.put(c,map.get(c)-1);
        }
        return true;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }

        int[] chars = new int[256];

        for(char c: magazine.toCharArray()){
            chars[c-'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(chars[c-'a'] ==0){
                return false;

            }
            chars[c-'a']--;

        }
        return true;
    }
}

// TC: O(n)
// SC: O(1)