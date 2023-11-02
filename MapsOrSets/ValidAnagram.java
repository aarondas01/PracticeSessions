class Solution {
    public boolean isAnagram(String s, String t) {
        //using frequecy array

        if(s.length() != t.length())
            return false;
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : t.toCharArray()){
            freq[c-'a']--;
        }
        for(int i : freq){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public boolean isAnagram(String s, String t) {
        //using HashMap

        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
        }

        for(int c : map.values()){
            if(c != 0){
                return false;
            }
        }
        return true;
    }
}
// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        for(int i=0;i< s1.length; i++){
            if(s1[i] != t1[i]){
                return false;
            }
        }
        return  true;

    }
}

// TC: O(nlogn)*O(mlogn)
// SC: O(m+n)