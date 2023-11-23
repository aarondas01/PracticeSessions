class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    List<Integer> list = new ArrayList<>();
    public int countNodes(TreeNode root) {
        int count = 0;

        if (root != null){
            countNodes(root.left);
            list.add(root.val);
            countNodes(root.right);

        }
        return list.size();
    }
}

// TC: O(n)
// SC: O(n)

