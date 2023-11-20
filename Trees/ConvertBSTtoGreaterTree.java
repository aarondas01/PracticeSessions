class Solution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        calcTree(root);
        modifyTree(root);
        return root;
    }

    private void calcTree(TreeNode root){
        if(root == null){
            return;
        }
        calcTree(root.left);
        sum += root.val;
        calcTree(root.right);
        return;
    }

    private void modifyTree(TreeNode root){
        if(root == null){
            return;
        }
        modifyTree(root.left);
        int temp = root.val;
        root.val = sum;
        sum = sum -temp;
        modifyTree(root.right);
        return;
    }
}

// TC: O(n)
// SC:O(1)



class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.right != null){
            convertBST(root.right);
        }
        sum += root.val;
        root.val = sum;

        if(root.left != null){
            convertBST(root.left);
        }
        return root;
    }
}

// TC: O(n)
// SC: O)(1)

