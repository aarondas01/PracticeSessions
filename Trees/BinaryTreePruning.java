class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(helper(root) == 0){
            return null;
        }
        return root;
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        //count the no of ones in leaf nodes
        if(node.left == null && node.right == null){
            if(node.val ==0){
                return 0;
            }
            else{
                return 1;
            }
        }

        int leftNodeOnes = helper(node.left);
        int rightNodeOnes = helper(node.right);

        if(leftNodeOnes ==0){
            node.left = null;
        }
        if(rightNodeOnes == 0){
            node.right = null;
        }

        return leftNodeOnes + rightNodeOnes + (node.val == 0 ? 0 : 1 );
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){

            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val != 1 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}

// TC: O(n)
// SC: O(n)

