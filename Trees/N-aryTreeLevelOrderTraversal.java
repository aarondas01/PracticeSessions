class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- >0){
                Node temp = queue.poll();
                list.add(temp.val);
                for(Node child : temp.children){
                    queue.add(child);
                }
            }
            result.add(list);
        }
        return result;
    }
}

// TC: O(n)
// SC: O(n)