/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        // DFS
        result = new ArrayList<>();

        levelOrderTraversal(root,0);
        return result;
    }


    private void levelOrderTraversal(TreeNode root, int level){
        if(root == null){
            return ;
        }

        if(level >= result.size()){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        levelOrderTraversal(root.left,level+1);
        levelOrderTraversal(root.right,level+1);
    }
}

// TC: O(N)
// SC: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            while(size-- > 0){
                TreeNode curr = queue.poll();
                currentList.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }
}

// TC: O(N)
// SC: O(N)