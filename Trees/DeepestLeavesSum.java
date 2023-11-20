class Solution {
    public int deepestLeavesSum(TreeNode root) {
        //BFS

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum  = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            //reset the value of sum at each level
            sum = 0;

            while(size >0){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }

        }
        return sum;
    }
}

// TC: O(n)
// SC:O(h)


class Solution {
    int sum = 0, maxDepth =0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int level){
        if(root== null){
            return;
        }
        if(level > maxDepth){
            maxDepth = level;
            sum =0;
        }
        if(level == maxDepth){
            sum += root.val;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

// TC: O(n)
// SC: O(1)