Binary Search Tree Iterator

class BSTIterator {

    //Iterative using stack
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        updateStack(node);
    }

    private void updateStack(TreeNode node){
        while(node != null){
            stack.add(node);
            node = node.left;
        }

    }

    public int next() {
        TreeNode node = stack.pop();
        updateStack(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

//  TC: O(n)
//  SC: O(h)



class BSTIterator {

    //Using DFS Queue
    Queue<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        //in order traversal call
        traverseBST(root,list);
    }


    private void traverseBST(TreeNode root, Queue<Integer> list){
        if(root == null){
            return;
        }
        traverseBST(root.left,list);
        list.add(root.val);
        traverseBST(root.right,list);
    }

    public int next() {
        return list.poll();

    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

//  TC: O(1)
//  SC: O(n)