
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        //BFS

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr.val >= low && curr.val <= high){
                sum += curr.val;
            }
            if(curr.left != null && curr.val > low){
                queue.add(curr.left);
            }
            if(curr.right != null && curr.val < high){
                queue.add(curr.right);
            }
        }
        return sum;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    private int sum =0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        //dfs

        dfs(root,low,high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }

        dfs(root.left,low,high);
        dfs(root.right,low,high);
    }
}

// TC: O(n)
// SC: O(n)

