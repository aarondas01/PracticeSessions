class Solution {
    public int sumNumbers(TreeNode root) {
        //recursive

        return traverse(root,0);
    }

    private int traverse(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return sum*10 + root.val;
        }
        return traverse(root.left,sum*10+root.val) + traverse(root.right, sum*10 + root.val);
    }
}

// TC: O(n^2)
// SC: O(1)


class Solution {
    public int sumNumbers(TreeNode root) {
        //iterative
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        queue.add(root);
        sumQueue.add(root.val);
        int sum = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode temp = new TreeNode(0);
            int tempSum =0;
            while(size-- > 0){
                temp = queue.poll();
                tempSum = sumQueue.poll();

                if(temp.left == null  && temp.right == null){
                    sum += tempSum;
                }

                if(temp.left != null){
                    queue.add(temp.left);
                    sumQueue.add(tempSum *10 + temp.left.val);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    sumQueue.add(tempSum*10 + temp.right.val);
                }
            }

        }
        return sum;
    }
}

// TC: O(mn)
// SC: O(mn)