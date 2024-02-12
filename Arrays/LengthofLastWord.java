class Solution {
    public int lengthOfLastWord(String s) {
        String last = s.trim();
        return last.length() - (last.lastIndexOf(" ")+1);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}