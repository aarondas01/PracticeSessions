class Solution {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        //brute force

        if(root==null){
            return null;
        }
        inorder(root);

        for(int i = 0 ; i < list.size()-1; i++){
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }

        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;

        return list.get(0);

    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    TreeNode curr = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode res = new TreeNode(0);
        curr = res;
        inorder(root);

        return res.right;

    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
}

// TC: O(n)
// SC: O(h)