class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //recursive
        if (root == null || p== root || q == root ){
            return root;
        }


        TreeNode right =  lowestCommonAncestor(root.left,p,q);
        TreeNode left =  lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;

    }
}

// TC: O(n)
// SC:O(n)


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // iterative
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val  < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                break;
            }
        }
        return root;
    }
}

// TC: O(h)
// SC:O(1)