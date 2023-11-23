class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val > key){
            root.left =  deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode next = nextInorder(root.right);
            root.val = next.val;
            root.right= deleteNode(root.right,next.val);
        }
        return root;
    }

    private TreeNode nextInorder(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

}

// TC: O(n)
// SCL O(n)