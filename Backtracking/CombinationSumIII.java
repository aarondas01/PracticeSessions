class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(1,result, new ArrayList<>(), k,n);
        return result;
    }

    private void generateCombinations(int index, List<List<Integer>> result, List<Integer> currentList, int k, int sum){
        if(currentList.size() == k && sum==0){
            result.add(new ArrayList<>(currentList));
            return ;
        }
        for(int i =index; i <= 9 ;i++){
            currentList.add(i);
            generateCombinations(i+1,result,currentList,k,sum-i);
            currentList.remove(currentList.size()-1);
        }
    }
}

// TC: O(2^n *n)
// SC: O(k)