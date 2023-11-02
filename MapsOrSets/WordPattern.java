class Solution {
    public boolean wordPattern(String pattern, String s) {
        //using HashMap

        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }

        HashMap<Character,String> map = new HashMap<>();
        for(int i = 0 ; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String str = words[i];

            if(!map.isEmpty() && map.containsKey(c) && map.get(c).equals(str)){
                continue;
            }
            if(!map.isEmpty() && map.containsKey(c) && !map.get(c).equals(str)){
                return false;
            }
            if(!map.isEmpty() && map.containsValue(str)){
                return false;
            }
            map.put(c,str);
        }
        return true;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public boolean wordPattern(String pattern, String s) {
        //uses two HashMap
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i = 0 ; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String str = words[i];

            if(!map1.containsKey(c)){
                map1.put(c,str);
            }
            if(!map2.containsKey(str)){
                map2.put(str,c);
            }
            if(!map1.get(c).equals(str) || !map2.get(str).equals(c) ){
                return false;
            }
        }
        return true;


    }
}

// TC: O(n)
// SC: O(n)