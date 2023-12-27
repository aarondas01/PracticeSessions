class Trie{
    public Trie[] children;
    List<Integer> index;

    Trie(){
        children = new Trie[26];
        index = new ArrayList<>();
    }

    public void insert(String word,int i) {
        Trie node = this;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
            node.index.add(i);
        }

    }

    public List<Integer> startsWith(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(node.children[index] == null){
                return new ArrayList<>();
            }
            node = node.children[index];
        }
        return node.index;
    }
}

class WordFilter {

    Trie prefix = null;
    Trie suffix = null;

    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();

        for(int i = 0 ; i < words.length; i++){
            prefix.insert(words[i],i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(),i);
        }
    }

    public int f(String pref, String suff) {
        List<Integer> prefixList = prefix.startsWith(pref);
        List<Integer> suffixList = suffix.startsWith(new StringBuilder(suff).reverse().toString());

        int i = prefixList.size()-1, j = suffixList.size()-1;

        while(i >=0 && j >=0 ){
            if(Objects.equals(prefixList.get(i), suffixList.get(j))){
                return prefixList.get(i);
            }
            else if(prefixList.get(i)> suffixList.get(j)){
                i--;
            }
            else{
                j--;
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//
//  TC: O(N*k) + O(k+n)
//  SC: O(n*k)