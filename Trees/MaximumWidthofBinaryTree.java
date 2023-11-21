class Solution {
    //BFS using Pair

    /*  create a queue to store TreeNode and integer
    initialize maxWidth to 0;
    add root to queue
    apply BFS on input
    return maxWidth */
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        //store the head of the queue in a variable head
        // initialize size of the queue
        // initialize a variable minIndex from queue peek
        // for each element in the queue while size >0
        // remove head and store in currentPair
        // store TreeNode from pair in a node
        // traverse
        // update the maxWidth

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        int maxWidth =  0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int minIndex = queue.peek().index;
            int firstNodeIndex = 0 , lastNodeIndex = 0;

            for(int i=0; i < size; i++){
                int currIndex = queue.peek().index - minIndex;
                TreeNode currNode = queue.poll().node;

                if(i==0){
                    firstNodeIndex = currIndex;
                }
                if(i == size-1){
                    lastNodeIndex = currIndex;
                }
                if(currNode.left != null){
                    queue.add(new Pair(currNode.left, 2 *currIndex+1));
                }
                if(currNode.right != null){
                    queue.add(new Pair(currNode.right, 2 * currIndex +2));
                }
            }
            int currWidth = lastNodeIndex-firstNodeIndex +1;
            maxWidth = Math.max(maxWidth,currWidth);
        }
        return maxWidth;

    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    //list will hold the start index at each level
    List<Integer>  list = new ArrayList<>();
    private    int maxWidth = 1;

    public int widthOfBinaryTree(TreeNode root) {
        //DFS

        dfs(root,0,1,list);
        return maxWidth;

    }

    private void dfs(TreeNode root, int level, int index, List<Integer> list){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(index);
        }
        maxWidth = Math.max(maxWidth,index+1 - list.get(level));
        dfs(root.left,level+1, 2*index,list);
        dfs(root.right,level+1, 2*index+1,list);

        // return maxWidth;
    }
}

// TC: O(n)
// SC: O(n)