Two Sum IV - Input is a BST

class Solution {
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        //two pointers
        if(root == null)
            return false;
        inorder(root);

        int left = 0, right = nums.size()-1;
        while(left < right){
            int sum = nums.get(left)+ nums.get(right);
            if(sum== k){
                return true;
            }
            else if (sum< k){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        //DFS
        if(root == null)
            return false;
        int diff = k - root.val;
        if(set.contains(diff))
            return true;
        set.add(root.val);

        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        //two pointers
        if(root == null)
            return false;
        inorder(root);

        int left = 0, right = nums.size()-1;
        while(left < right){
            int sum = nums.get(left)+ nums.get(right);
            if(sum== k){
                return true;
            }
            else if (sum< k){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}

// TC: O(n)
// SC: O(n)