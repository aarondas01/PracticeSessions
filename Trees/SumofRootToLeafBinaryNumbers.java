class Solution {
    int totalSum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        //(root, currentSum =0)
        sumRootToLeafHelper(root,0);
        return totalSum;
    }

    private void sumRootToLeafHelper(TreeNode root, int currentSum){
        if(root ==  null){
            return;
        }
        currentSum += root.val;
        if(root.left == null && root.right == null){
            totalSum += currentSum;
        }

        sumRootToLeafHelper(root.left,currentSum*2);
        sumRootToLeafHelper(root.right,currentSum*2);


    }
}
// TC: O(n)
// SC: O(logn)
