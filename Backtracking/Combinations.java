class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(result,1,n,k, new ArrayList<>());
        return result;
    }


    private void generateSubsets(List<List<Integer>> result , int index, int n, int k, List<Integer> current){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i <= n ; i++){
            current.add(i);
            generateSubsets(result, i+1,n, k, current);
            current.remove(current.size()-1);
        }
    }
}

// TC: O(n * 2^n)
// SC: O(n)