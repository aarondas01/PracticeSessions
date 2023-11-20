class Solution {
    public void recoverTree(TreeNode root) {
        //using extra space
        List<TreeNode> list = new ArrayList<>();
        inorderTraversal(root,list);

        int start =-1;
        int end = list.size()-1;

        for(int i = 0 ; i < end; i++){
            if(start  == -1 && list.get(i).val > list.get(i+1).val ){
                start = i;
            }
            else if(start != -1 && list.get(start).val < list.get(i+1).val){
                end = i;
                break;
            }
        }
        int temp = list.get(start).val;
        list.get(start).val = list.get(end).val;
        list.get(end).val = temp;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root);
        inorderTraversal(root.right,list);
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    TreeNode start = null;
    TreeNode prev = null;
    TreeNode end = null;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        int temp = start.val;
        if(end == null){
            end = prev;
        }
        start.val = end.val;
        end.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        if(start == null && prev.val > root.val){
            start = prev;
        }
        else if (start != null && start.val < root.val){
            end = prev;
            return;
        }
        prev = root;
        inorder(root.right);


    }
}

// TC: O(n)
// SC: O(logn)