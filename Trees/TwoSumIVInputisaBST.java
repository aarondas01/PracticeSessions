class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // BFS
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int diff = k - curr.val;

            if(set.contains(diff)){
                return true;
            }
            set.add(curr.val);

            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        return false;


    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        //DFS
        if(root == null){
            return false;
        }
        int diff = k - root.val;
        if(set.contains(diff)){
            return true;
        }
        set.add(root.val);

        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}

// TC: O(n)
// SC: O(n)
