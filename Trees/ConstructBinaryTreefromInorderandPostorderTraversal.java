Construct Binary Tree from Inorder and Postorder Traversal

class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //using map

        int n = inorder.length;
        for(int i =0 ; i <n; i++){
            map.put(inorder[i],i);
        }

        return constructTree(inorder,0,n-1, postorder,0 , n-1);

    }

    private TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.val);

        int numsLeft = rootIndex-inStart;

        root.left = constructTree(inorder,inStart,rootIndex-1, postorder,postStart, postStart+numsLeft-1);
        root.right = constructTree(inorder,rootIndex+1,inEnd,postorder,postStart+ numsLeft,postEnd-1);

        return root;

    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;

        int inStart = 0;
        int inEnd = n-1;

        int postStart = 0;
        int postEnd = n-1;

        return solve(inorder,postorder, inStart, inEnd, postStart, postEnd);
    }


    private TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int i = inStart;
        for(; i <= inEnd; i++){
            if(inorder[i] == root.val){
                break;
            }
        }

        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = solve(inorder,postorder,inStart, i-1,postStart, postStart+leftSize-1);
        root.right = solve(inorder,postorder,i+1,inEnd,postEnd-rightSize,postEnd-1);

        return root;
    }
}

// TC: O(n)
// SC: O(1)