/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int min= Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        //recursive

        //inorder traversal
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node){
        if(node == null){
            return ;
        }

        inorder(node.left);
        if(prev != null){
            min = Math.min(min,node.val-prev.val);
        }
        prev = node;
        inorder(node.right);
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root, prev = null;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if(prev != null) {
                min = Math.min(min, curr.val - prev.val);
            }
            prev = curr;
            curr = curr.right;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return min;
    }
}

// TC: O(n)
// SC: O(n)