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

    int count  = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {

        inorderTraversal(root,k);
        return result;
    }

    private void inorderTraversal(TreeNode root, int k){
        if(root == null){
            return;
        }

        inorderTraversal(root.left,k);

        if(++count == k){
            result = root.val;
            return;
        }

        inorderTraversal(root.right,k);

    }
}

// TC: O(n)
// SC: O(logn)


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //iterative

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        int count  = 0;


        while(temp!= null || !stack.isEmpty()){

            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                TreeNode curr = stack.pop();
                if(++count == k){
                    return curr.val;
                }
                temp = curr.right;
            }
        }
        return -1;
    }
}

// TC: O(n)
// SC: O(n)
