class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //compare the nodes not the node values

        //move left in original move left in cloned tree
        //move right in original , move right in cloned tree

        if(original == null){
            return original;
        }

        if(original == target){
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left,cloned.left, target);

        if(left != null){
            return left;
        }
        TreeNode right = getTargetCopy(original.right,cloned.right, target);
        if(right != null){
            return right;
        }
        return null;
    }
}

// TC: O(n)
// SC: O(n)