class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        //recursive
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length==1){
            return root;
        }
        for(int i=1; i< preorder.length ; i++){
            createTree(root,preorder[i]);
        }
        return root;
    }

    private void createTree(TreeNode root, int val){
        if(root.val < val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }
            else{
                createTree(root.right,val);
            }
        }
        else{
            if(root.left == null ){
                root.left = new TreeNode(val);
            }
            else{
                createTree(root.left,val);
            }

        }
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for(int i=1; i < preorder.length; i++){
            TreeNode temp = null;
            while(!stack.isEmpty()  && preorder[i] > stack.peek().val){
                temp = stack.pop();
            }
            if(temp == null){
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
            else{
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            }
        }
        return root;
    }
}

// TC: O(n)
// SC: O(n)