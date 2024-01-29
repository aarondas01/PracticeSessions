class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null || s.length() == 0 || words.length == 0){
            return new ArrayList<>();
        }
// - We calculate word length & total words, create a frequency map of given words
// - Now we iterate each index & check if word exists in frequency map
// - If doesn't exists then break.
// - We also take seenWords map, where we put words which are seen in for this index
// - If seenWords value is more than actual frequency exists, then also we break
// - If totalWords are equal to the found words, then we add the index in result.
// - At last, we return result
        Map<String,Integer> frequencyMap = new HashMap<>();

        for(String str : words){
            frequencyMap.put(str, frequencyMap.getOrDefault(str,0)+1);
        }

        int eachWordLength = words[0].length();
        int totalWords = words.length;

        List<Integer> result = new ArrayList<>();


        for(int i = 0 ; i <= s.length()-totalWords*eachWordLength;i++){
            Map<String,Integer> seenWords = new HashMap<>();

            for(int j = 0 ; j < totalWords; j++){
                int wordIndex = i+j*eachWordLength;

                String word = s.substring(wordIndex, wordIndex+eachWordLength);
                if(!frequencyMap.containsKey(word)){
                    break;
                }

                seenWords.put(word, seenWords.getOrDefault(word,0)+1);

                if(seenWords.get(word) > frequencyMap.get(word)){
                    break;
                }
                if(j+1 == totalWords){
                    result.add(i);
                }
            }
        }
        return result;
    }
}

// TC: O(n*m*length) total words *word length * each word length
// SC: O(m) total words