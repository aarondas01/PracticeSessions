class Solution {
    public int longestStrChain(String[] words) {
        //length goes from low to high so we need to sort
        //use branches (memoization)

        //sort based on length
        //for memoization use map <string,maxChainLength>

        //check if there exists entry in the map by deleting a character

        Arrays.sort(words, (a,b) -> (a.length()-b.length()));
        //<string,maxChainLength>
        Map<String,Integer> map = new HashMap<>();

        int maxLen =1;

        for(String word : words){
            int currLen =1;
            StringBuilder sb = new StringBuilder(word);

            for(int i =  0 ; i < word.length(); i++){
                sb.deleteCharAt(i);
                String prevWord = sb.toString();
                currLen = Math.max(currLen, map.getOrDefault(prevWord,0)+1);
                sb.insert(i,word.charAt(i));
            }
            map.put(word,currLen);
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;

    }
}

// TC: O(nlogn + n  * m^2)
// Sc : O(n)

