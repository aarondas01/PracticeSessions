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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //BFS
        //solve biary tree level order traversal before this for
        //better undersatnding

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            while(size-- >0){
                TreeNode curr = queue.poll();

                if(flag){
                    stack.push(curr.val);
                }
                else{
                    currentList.add(curr.val);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            flag = !flag;

            while(!stack.isEmpty()){
                currentList.add(stack.pop());
            }
            result.add(currentList);
        }
        return result;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag=false;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();

            while(size-- >0){
                TreeNode curr = queue.poll();
                if(flag){
                    currentList.add(0,curr.val);
                }
                else{
                    currentList.add(curr.val);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            flag = !flag;
            result.add(currentList);
        }
        return result;
    }
}

// TC: O(n)
// SC: O(n)