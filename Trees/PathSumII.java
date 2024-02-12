class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        findPathDFS(root,targetSum, result, new ArrayList<>());
        return result;
    }

    private void findPathDFS(TreeNode root, int targetSum,List<List<Integer>> result ,List<Integer> currentList ){
        if(root == null){
            return;
        }
        currentList.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum){
            result.add(currentList);
            return;
        }

        findPathDFS(root.left,targetSum-root.val,result,new ArrayList<>(currentList));
        findPathDFS(root.right, targetSum -root.val, result, new ArrayList<>(currentList));
    }
}

// TC: O(n)
// SC: O(n)