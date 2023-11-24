class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        postOrder(root);
        return maxSum;
    }

    private int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0,postOrder(root.left));
        int right = Math.max(0,postOrder(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left,right) + root.val;

    }
}

// TC: O(n)
// SC: O(h)