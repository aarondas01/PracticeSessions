class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                char[] chars = queue.poll().toCharArray();

                for(int j = 0 ; j < chars.length; j++){
                    char temp  = chars[j];
                    for(char ch = 'a'; ch <= 'z' ; ch++){
                        chars[j] = ch;

                        String newWord = new String(chars);
                        if(dictionary.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return level+1;
                            }
                            queue.add(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    chars[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}

// TC: O(n^2*w)
// SC: O(n^2 *w)