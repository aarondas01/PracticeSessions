
class StreamChecker {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    private TrieNode root = null;

    private StringBuilder qryStr;


    public StreamChecker(String[] words) {
        root = new TrieNode();
        qryStr = new StringBuilder();

        for(String word : words){
            addWord(word);
        }
    }

    private void addWord(String word){
        TrieNode node = root;

        for(int i = word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            int index = c- 'a';
            if(node != null && node.children[index] == null){
                TrieNode newNode = new TrieNode();
                node.children[index] = newNode;
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String qryStr) {
        TrieNode node = root;
        for(int i = qryStr.length()-1; i >=0; i-- ){
            char c = qryStr.charAt(i);
            int index = c - 'a';
            if(node != null && node.children[index] != null){
                node = node.children[index];
                if(node.isEnd){
                    return true;
                }

            }
            else{
                return false;
            }

        }
        return false;
    }

    public boolean query(char letter) {
        qryStr.append(letter);
        return search(qryStr.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

//TC: O(m*l)
//SC: O(m*l)