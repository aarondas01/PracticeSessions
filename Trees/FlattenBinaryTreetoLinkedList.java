class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //recursion

        if(root == null){
            return;
        }
        flattenTree(root);
    }

    private void flattenTree(TreeNode root){
        if(root.right != null){
            flattenTree(root.right);
        }
        if(root.left != null){
            flattenTree(root.left);
        }

        root.left = null;
        root.right = prev;
        prev = root;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        //iterative

        preOrderTraversal(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            curr.left = null;
            curr.right = queue.peek();
        }
    }
    private void preOrderTraversal(TreeNode root){
        if(root != null){
            queue.add(root);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public void flatten(TreeNode root) {
        //Morris Traversal
        //if left is not null traverse to the rightmost child
        //connect it to root right
        //connect the whole left to root right
        // make root left as null
        //update root to root right

        if(root == null){
            return;
        }

        while(root != null){
            if(root.left != null){
                TreeNode left = root.left;
                TreeNode curr = left;

                while(curr.right != null){
                    curr = curr.right;
                }
                curr.right = root.right;
                root.left = null;
                root.right = left;


            }
            root = root.right;
        }
    }
}

// TC: O(n)
// SC: O(1)