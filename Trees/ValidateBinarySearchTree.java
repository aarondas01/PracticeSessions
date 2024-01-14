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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return checkBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return checkBST(root.left,min, root.val) && checkBST(root.right, root.val, max);
    }
}

// TC: O(n)
// SC: O(n)


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
    public boolean isValidBST(TreeNode root) {
        //using extra space
        List<Integer> list = new ArrayList<>();

        boolean isBST = true;
        preOrderTraversal(root,list);

        int  prev = list.get(0);
        for(int i = 1 ; i < list.size(); i++){
            if(list.get(i) <= prev){
                isBST= false;
            }
            prev = list.get(i);
        }
        return isBST;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left,list);
        list.add(root.val);
        preOrderTraversal(root.right,list);
    }
}

// TC: O(n)
// SC: O(n)