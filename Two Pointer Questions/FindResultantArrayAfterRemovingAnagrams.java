class Solution {
    public List<String> removeAnagrams(String[] words) {
        int low = 0 ;
        List<String> result = new ArrayList<>();

        int[] prev = frequency(words[low]);

        for(int i =1; i < words.length; i++){
            int[] curr = frequency(words[i]);
            if(Arrays.equals(curr,prev)){
                continue;
            }
            result.add(words[low]);
            low  = i ;
            prev = frequency(words[low]);
        }
        result.add(words[low]);
        return result;
    }

    private int[] frequency(String word){
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public List<String> removeAnagrams(String[] words) {
        //sorting
        List<String> res = new ArrayList<>();
        String prev = "";
        for(int i = 0 ; i < words.length; i++){
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if(!curr.equals(prev)){
                res.add(words[i]);
                prev = curr;
            }
        }
        return res;
    }
}
// TC: O(nlogn)
// SC: O(n)