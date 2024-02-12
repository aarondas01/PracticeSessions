class Solution {
    public boolean isIsomorphic(String s, String t) {
        //using HashMap

        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();

        for(int i = 0;i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(map.containsKey(a)){
                if(map.get(a).equals(b)){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                if(!map.containsValue(b)){
                    map.put(a,b);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public boolean isIsomorphic(String s, String t) {
        // using frequncey array

        if(s.length() != t.length()){
            return false;
        }

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for(int i = 0 ; i < s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]){
                return false;
            }
            map1[s.charAt(i)] = map2[t.charAt(i)] = i+1;
        }
        return true;

    }
}

// TC: O(n)
// SC: O(1)