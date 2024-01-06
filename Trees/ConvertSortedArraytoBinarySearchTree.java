class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0, nums.length-1);
    }

    private TreeNode createBST(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,start,mid-1);
        root.right = createBST(nums, mid+1, end);
        return root;
    }
}