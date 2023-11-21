class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        // DFS recursive
        if(depth ==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insert(root,val,1, depth);
        return root;
    }


    private void insert(TreeNode node, int val, int currentDepth, int depth){
        if(node == null){
            return;
        }

        if(currentDepth == depth -1){
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        else{
            insert(node.left, val,currentDepth+1,depth);
            insert(node.right, val,currentDepth+1,depth);

        }
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //BFS iterative

        if(depth == 1){

            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth =1;

        while(currentDepth < depth-1){
            //take a temp queue
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode curr = queue.remove();
                if(curr.left != null){
                    temp.add(curr.left);
                }
                if(curr.right != null){
                    temp.add(curr.right);
                }
            }
            queue = temp;
            currentDepth++;

        }
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}

// TC: O(n)
// SC: O(x)