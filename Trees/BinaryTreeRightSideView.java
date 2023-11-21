class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //Iterative BFS

        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size  >0){
                TreeNode node = queue.poll();
                if(size ==1){
                    result.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
        }
        return result;

    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    int depth  = 0;
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // ..recursive DFS
        if(root == null){
            return result;
        }

        depth++;
        if(result.size()<depth){
            result.add(root.val);
        }
        result = rightSideView(root.right);
        result = rightSideView(root.left);
        depth--;

        return result;
    }
}

// TC: O(n)
// SC: O(h)

