class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //backtracking

        List<List<Integer>> result = new ArrayList<>();

        generateCombinations(0,result, candidates, target, new ArrayList<>() );
        return result;
    }

    private void generateCombinations(int index, List<List<Integer>> result, int[] candidates, int target, List<Integer> combo){
        if(target < 0 || index >= candidates.length){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(combo));
            return;
        }

        for(int i = index;  i < candidates.length; i++){
            combo.add(candidates[i]);
            generateCombinations(i,result, candidates, target-candidates[i], combo);
            combo.remove(combo.size()-1);
        }
    }
}

// TC: O(2^n)
// SC: O(2^n)