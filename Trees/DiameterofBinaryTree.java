class Solution {
    int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        getDiameter(root);
        return diam;
    }

    private int getDiameter(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);

        diam = Math.max(diam, left+right+2);
        return 1 + Math.max(left,right);
    }
}

// TC: O(N)
// SC: O(h)

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        //iterative

        Map<TreeNode,Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        int diameter  = 0;

        if(root !=  null){
            stack.push(root);
        }


        while(!stack.isEmpty()){
            TreeNode node = stack.peek();

            if(node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            }
            else if(node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            }
            else{
                stack.pop();
                int left = map.getOrDefault(node.left,0);
                int right = map.getOrDefault(node.right,0);

                map.put(node,1 + Math.max(left,right));
                diameter = Math.max(diameter,left+right);

            }
        }
        return diameter;
    }
}

// TC: O(n)
// SC: O(n)

