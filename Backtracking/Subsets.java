class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,result,nums, new ArrayList<>());
        return result;

    }

    private void backtrack(int index, List<List<Integer>> result, int[] nums, List<Integer> current){
        result.add(new ArrayList<>(current));

        for(int i =index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(i+1,result,nums,current);
            current.remove(current.size()-1);
        }
    }
}

// TC: O(n*2^n)
// SC: O(n)

