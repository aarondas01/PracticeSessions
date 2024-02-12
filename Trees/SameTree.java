class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //DFS

        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //BFS
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        if(p != null){
            q1.add(p);
        }
        if(q != null){
            q2.add(q);
        }

        while(!q1.isEmpty()  && !q2.isEmpty()){
            TreeNode temp1 = q1.poll();
            TreeNode temp2 = q2.poll();

            if(temp1.val != temp2.val){
                return false;
            }

            if(temp1.left != null && temp2.left != null){
                q1.add(temp1.left);
                q2.add(temp2.left);
            }
            else if((temp1.left == null && temp2.left != null) || (temp1.left !=null && temp2.left == null)){
                return false;
            }
            if(temp1.right != null && temp2.right != null){
                q1.add(temp1.right);
                q2.add(temp2.right);
            }
            else if((temp1.right == null && temp2.right != null) || (temp1.right !=null && temp2.right == null)){
                return false;
            }

        }
        return  true;
    }
}

// TC: O(n)
// SC: O(N)