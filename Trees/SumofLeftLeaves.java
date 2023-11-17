class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        //dfs
        if(root == null){
            return 0;
        }

        if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        //iterative BFS

        if(root == null){
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(isLeaf(node.left)){
                sum += node.left.val;

            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null){
            return true;
        }
        return  false;
    }
}

// TC: O(n)
// SC: O(n)

