class Solution {
    private int maxDiff =0;

    //the maximum difference can be when the  ancestor is min and node is max
    // or when the ancestor is max and node is min
    public int maxAncestorDiff(TreeNode root) {

        if(root ==  null){
            return maxDiff;
        }
        helper(root);
        return maxDiff;
    }
    //max,min
    private int[] helper(TreeNode root){
        if(root ==  null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = helper(root.left);
        int[] right= helper(root.right);

        int leftMin  = left[0];
        int rightMin = right[0];
        int min =Math.min(root.val,Math.min(leftMin,rightMin));


        int leftMax = left[1];
        int rightMax = right[1];
        int max = Math.max(root.val, Math.max(leftMax,rightMax));

        maxDiff=  Math.max((max-root.val),Math.max((root.val-min),maxDiff));

        return new int[]{min,max};
    }
}

// TC: O(N)
// SC: O(n)

