class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        //use post order traversal

        postorder(root);
        return sum;
    }

    private int postorder(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);

        sum += Math.abs(left-right);

        return left + right + root.val;

    }
}

//TC: O(n)
//SC: O(n)