class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder reverse = new StringBuilder();

        for(int i = words.length-1; i >= 0; i--){
            if(words[i] != "" ){
                reverse.append(words[i]);
                reverse.append(" ");
            }
        }
        return reverse.toString().trim();
    }
}

// TC: O(n)
// sC: O(n)