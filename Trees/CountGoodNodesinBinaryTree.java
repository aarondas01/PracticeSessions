class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int res = root.val >= max ? 1 : 0;
        max = Math.max(max,root.val);
        res += countGoodNodes(root.left,max);
        res += countGoodNodes(root.right, max);

        return res;
    }
}

// TC: O(n)
// SC: O(logn)