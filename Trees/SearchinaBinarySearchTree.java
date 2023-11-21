class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root;
            }
            else if(root.val < val){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return null;
    }
}

// TC : O(logn)
// SC: O(1)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        //using Stack
        if(root == null || root.val == val){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        if(root.val < val){
            stack.push(root.right);
        }else{
            stack.push(root.left);
        }


        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            if(currNode != null){
                if(currNode.val == val){
                    return currNode;
                }
                if(currNode.val < val){
                    stack.push(currNode.right);
                }
                else{
                    stack.push(currNode.left);
                }
            }

        }
        return null;
    }
}

// TC: O(n)
// SC: O(n)