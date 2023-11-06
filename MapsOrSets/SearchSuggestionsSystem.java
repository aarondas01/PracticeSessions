//Trie
class TrieNode{
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }

    public void insert(String word,TrieNode root){
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(root.children[index] == null){
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.isWord = true;
    }

    public List<String> searchWords(String word,TrieNode root){
        TrieNode node = root;
        List<String> words = new ArrayList<>();
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                return words;
            }
            node= node.children[index];
        }
        dfs(node,word,words);
        return words;
    }

    public void dfs(TrieNode root, String word, List<String> words){
        if(words.size() == 3)
            return;
        if(root.isWord == true){
            words.add(word);
        }
        for(char c = 'a'; c <= 'z';c++){
            if(root.children[c-'a'] != null){
                dfs(root.children[c-'a'], word +c, words);
            }
        }
    }
}
class Solution {


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        for(String product : products){
            root.insert(product,root);
        }
        List<List<String>> result = new ArrayList<>();
        for(int i = 1; i <= searchWord.length(); i++){
            result.add(root.searchWords(searchWord.substring(0,i),root));
        }
        return result;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int left = 0 , right = products.length -1;
        for(int i = 0;  i < searchWord.length(); i++){
            List<String> res = new ArrayList<>();
            char c = searchWord.charAt(i);
            while(left <= right && (products[left].length() == i || products[left].charAt(i)<c))
                left++;
            while(left  <= right && (products[right].length() == i || products[right].charAt(i) > c))
                right--;
            for(int j = 0 ; j < 3 && left +j <= right ; j++){
                res.add(products[left+j]);
            }
            ans.add(res);
        }
        return ans;
    }
}
// TC: O(n*logn)
// SC: O(1)