class Solution {
    private int count  = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return count;
        }
        postOrder(root);
        return count;
    }


    private int[] postOrder(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int totalSum = left[0] + right[0] + root.val;
        int totalNodes = left[1]+right[1] +1;

        if(totalSum/totalNodes == root.val){
            count++;
        }
        return new int[]{totalSum,totalNodes};
    }
}

// TC: O(n)
// SC: O(n)