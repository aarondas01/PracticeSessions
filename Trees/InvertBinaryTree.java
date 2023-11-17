class Solution {
    public TreeNode invertTree(TreeNode root) {
        //DFS
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }
}

// TC: O(n)
// SC: O(h)


class Solution {
    public TreeNode invertTree(TreeNode root) {
        //BFS
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }

        }
        return root;
    }
}

// TC: O(n)
// SC: O(n)