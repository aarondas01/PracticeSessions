class Solution {
    public List<List<String>> partition(String s) {
        //backtracking
        List<List<String>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(), s,0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int index){
        if(index == s.length()){
            result.add(new ArrayList<>(current));
        }
        for(int i = index ; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                backtrack(result,current,s,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start< end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// TC: O(n*2^n)
// SC: O(n)