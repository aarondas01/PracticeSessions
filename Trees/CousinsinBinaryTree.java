
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //BFS Iterative
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode xParent = null, yParent = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                    if(node.left.val == x){
                        xParent = node;
                    }
                    if(node.left.val == y){
                        yParent = node;
                    }
                }
                if(node.right != null){
                    queue.add(node.right);

                    if(node.right.val == x){
                        xParent = node;
                    }
                    if(node.right.val == y){
                        yParent = node;
                    }
                }

                if(xParent != null && yParent != null){
                    //same parents means not cousins
                    //different parent means cousins
                    return xParent != yParent;
                }
            }
            if((xParent == null && yParent != null ) ||(xParent != null && yParent == null)){
                return false;
            }
        }
        return false;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    private int xDepth  = -1;
    private int yDepth = -2;

    private TreeNode xParent =  null;
    private TreeNode yParent =  null;
    public boolean isCousins(TreeNode root, int x, int y) {
        // DFS recursive
        if(root == null){
            return false;
        }
        //root,x,y,depth,parent
        isCousinsHelper(root,x,y,0,null);

        //depth is same but parents are different hence cousins
        return xDepth == yDepth && xParent != yParent;
    }


    private void isCousinsHelper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }
        else if (root.val == y){
            yParent = parent;
            yDepth = depth;
        }
        else{
            isCousinsHelper(root.left,x,y,depth+1,root);
            isCousinsHelper(root.right,x,y,depth+1,root);

        }
    }
}

// TC: O(n)
// SC: O(n)