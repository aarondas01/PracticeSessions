class Solution {
    public boolean isSymmetric(TreeNode root) {
        //DFS

        if(root== null){
            return true;
        }
        return checkSymmetry(root.left, root.right);
    }


    private boolean checkSymmetry(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);




        }
        return true;
    }
}

// TC: O(n)
// SC: O(n)