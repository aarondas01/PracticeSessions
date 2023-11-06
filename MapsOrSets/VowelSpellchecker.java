class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        //all letters are same - case sensitive - return word
        //all letters are same - case insensitive - return word
        //all consonants are equal (case insensitive) vowels can be substituted with another vowel - return word
        //no match - return ""

        //Set exact match
        //Map case insensitive word
        //Map case insensitive consonants only

        Set<String> set =new HashSet<>();
        Map<String,String> caseInsensitive = new HashMap<>();
        Map<String, String> consonants = new HashMap<>();

        for(String word  : wordlist){
            set.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(),word);
            consonants.putIfAbsent(devowel(word.toLowerCase()),word);
        }

        String[] result = new String[queries.length];

        int i = 0;
        for(String query : queries){
            if(set.contains(query)){
                result[i] = query;
            }
            else if(caseInsensitive.containsKey(query.toLowerCase())){
                result[i] = caseInsensitive.get(query.toLowerCase());
            }
            else if(consonants.containsKey(devowel(query.toLowerCase()))){
                result[i] = consonants.get(devowel(query.toLowerCase()));
            }
            else{
                result[i] = "";
            }
            i++;
        }
        return result;
    }

    private String devowel(String word){
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            sb.append(isVowel(c) ? "*" : c);
        }
        return sb.toString();
    }
    private boolean isVowel(char c){
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        if(vowelSet.contains(c)){
            return true;
        }
        return false;
    }
}
// TC: O(n +m)
// SC: O(n+m)