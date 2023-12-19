class Solution {
    public int maxDepth(TreeNode root) {
        //DFS
        if(root == null){
            return 0;
        }
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left,right);
        }
    }
}

// TC: O(n)
// SC: O(h)

class Solution {
    public int maxDepth(TreeNode root) {
        //BFS

        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

// TC: O(n)
// SC: O(n)