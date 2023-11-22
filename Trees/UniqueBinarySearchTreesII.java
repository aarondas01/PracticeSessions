class Solution {
    public List<TreeNode> generateTrees(int n) {
        //recursively
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        for(int i= start ;  i <= end ; i++){
            List<TreeNode> leftTrees = helper(start,i-1);
            List<TreeNode> rightTrees = helper(i+1,end);

            for(TreeNode leftT : leftTrees){
                for(TreeNode rightT : rightTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = leftT;
                    node.right = rightT;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
// TC: O(n^2)
// SC: O(n^2)