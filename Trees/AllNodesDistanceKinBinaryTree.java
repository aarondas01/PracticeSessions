/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();


        //all node values are distinct

        parentTracker(root,parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        //add the target not the root
        queue.add(target);
        visited.put(target,true);
        int currentLevel = 0;

        while(!queue.isEmpty()){
            if(currentLevel++ == k){
                break;
            }
            int size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null && !visited.containsKey(curr.left)){
                    visited.put(curr.left,true);
                    queue.add(curr.left);
                }
                if(curr.right != null && !visited.containsKey(curr.right)){
                    visited.put(curr.right,true);
                    queue.add(curr.right);
                }
                if(parentMap.get(curr) != null && !visited.containsKey(parentMap.get(curr))){
                    visited.put(parentMap.get(curr),true);
                    queue.add(parentMap.get(curr));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }


    private void parentTracker(TreeNode root,HashMap<TreeNode,TreeNode> parentMap){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    parentMap.put(curr.left,curr);
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    parentMap.put(curr.right,curr);
                    queue.add(curr.right);
                }
            }
        }
    }
}

// TC: O(n)
// SC: O(n)