class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //DFS
        //optimized recursion

        if(root== null){
            return  false;
        }

        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}

// TC: O(2^n)
// SC: O(n)

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //iterative using stack

        if(root == null){
            return false;
        }

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> pathSum = new Stack<>();

        path.push(root);
        pathSum.push(root.val);

        while(!path.isEmpty()){
            TreeNode curr = path.pop();
            int currVal = pathSum.pop();


            if(curr.left == null && curr.right == null && currVal == targetSum){
                return true;
            }

            if(curr.left != null){
                path.push(curr.left);
                pathSum.push(curr.left.val + currVal);
            }
            if(curr.right != null){
                path.push(curr.right);
                pathSum.push(curr.right.val + currVal);
            }
        }
        return false;
    }
}

// TC: O(n)
// SC: O(n)