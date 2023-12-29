class MapSum {
    TrieNode root = null;

    class TrieNode{

        int weight;
        TrieNode[] children;

        public TrieNode(){
            weight = 0;
            children = new TrieNode[26];
        }


    }

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String word,int val) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.weight = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null){
                return 0;
            }
            node = node.children[c-'a'];
        }
        return dfs(node);
    }

    private int dfs(TrieNode node){
        int sum = 0;
        for(char c ='a'; c <= 'z'; c++){
            if(node.children[c-'a'] != null){
                sum += dfs(node.children[c-'a']);
            }
        }
        return sum + node.weight;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

//  TC: O(n)
//  SC: O(1)