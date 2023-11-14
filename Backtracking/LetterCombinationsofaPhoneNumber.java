class Solution {
    public List<String> letterCombinations(String digits) {
        //backtracking
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] mapping = new String[]{"0", "1","abc", "def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder combination = new StringBuilder();

        backtrack(result,combination, digits,0,mapping);
        return result;
    }

    private void backtrack(List<String> result , StringBuilder combination, String digits, int index, String[] mapping){
        if(index == digits.length()){
            result.add(combination.toString());
        }
        else{
            String letters = mapping[digits.charAt(index)-'0'];
            for(char c : letters.toCharArray()){
                combination.append(c);
                backtrack(result,combination,digits,index+1,mapping);
                combination.deleteCharAt(combination.length()-1);
            }
        }
    }
}

// TC: O(3^m * 4^n)
// SC: O(3^m * 4^n)