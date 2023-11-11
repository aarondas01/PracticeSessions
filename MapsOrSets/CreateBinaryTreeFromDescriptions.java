class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int[] des : descriptions){
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            set.add(child);

            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));

            if(isLeft == 1){
                parentNode.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child,parentNode.left);
            }
            else{
                parentNode.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.right);
            }
            map.put(parent, parentNode);
        }
        int root =-1;
        for(int[] des : descriptions){
            if(!set.contains(des[0])){
                root = des[0];
                break;
            }
        }
        return map.getOrDefault(root,null);
    }
}

// TC: O(n)
// SC: O(n)