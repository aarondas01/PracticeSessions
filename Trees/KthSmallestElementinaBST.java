class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //iterative

        Stack<TreeNode> stack = new Stack<>();

        int count = 0;
        TreeNode temp = root;

        while(temp != null || !stack.isEmpty()){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                TreeNode node = stack.pop();
                if(++count == k){
                    return node.val;
                }
                temp = node.right;
            }
        }
        return -1;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {

        // recursive inorder
        traversal(root,k);
        return res;
    }

    private void traversal(TreeNode root, int k){
        if(root == null){
            return;
        }
        traversal(root.left,k);

        if(++count == k){
            res = root.val;
        }
        traversal(root.right,k);
    }
}

// TC: O(n)
// SCL O(logn)