class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        //uses sorting
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = new String(chars);

            if(!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

// TC: O(nlogn)
// SC: O(n)


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        //uses frequency array
        for(String str : strs){
            char[] chars = new char[26];
            for(char c : str.toCharArray()){
                chars[c-'a']++;
            }
            String keyStr = new String(chars);

            if(!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

// TC: O(n*k)
// SC: O(n)