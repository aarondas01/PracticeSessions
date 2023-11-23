class Solution {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        helper(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void helper(TreeNode root, long targetSum){
        if(root == null){
            return;
        }
        if(root.val == targetSum){
            res++;
        }
        targetSum = targetSum-root.val;
        helper(root.left,targetSum);
        helper(root.right,targetSum);

    }
}

// TC: O(n^2)
// SC: O(logn)


class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        //using map prefix sum
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return findPathSum(root,targetSum,map, 0L);
    }

    private int findPathSum(TreeNode root, int targetSum,Map<Long,Integer> map, Long currentSum ){
        int res  = 0;
        if(root == null){
            return res;
        }

        currentSum += root.val;

        if(map.containsKey(currentSum-targetSum)){
            res += map.get(currentSum-targetSum);
        }
        map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        res += findPathSum(root.left,targetSum,map,currentSum);
        res += findPathSum(root.right,targetSum,map,currentSum);
        map.put(currentSum, map.getOrDefault(currentSum,0)-1);
        return res;
    }
}

// TC: O(n)
// SC: O(n)