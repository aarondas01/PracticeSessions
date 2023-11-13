class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        backtrack(result,nums, new ArrayList<>(),new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length && !result.contains(current)){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i < nums.length;i++){
            if(visited[i] || (i>0 && nums[i] == nums[i-1] && !visited[i-1])){
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(result,nums,current,visited);
            visited[i] = false;
            current.remove(current.size()-1);
        }
    }
}

// TC: O(n*n!)
// SC: O(n*n)

