class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //BFS

        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(0));
        int end = graph.length-1;

        while(!queue.isEmpty()){
            List<Integer> list = queue.poll();
            int current = list.get(list.size()-1);

            if(current == end){
                res.add(new ArrayList<>(list));
            }

            for(int node  : graph[current]){
                List<Integer> newPath = new ArrayList<>(list);
                newPath.add(node);
                queue.add(newPath);
            }
        }
        return res;
    }
}

// TC: O(V+E)
// SC: O(V)


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //DFS

        List<Integer> current = new ArrayList<>();
        current.add(0);
        int src= 0 ;
        int target = graph.length-1;

        dfs(graph,src,target,current);
        return res;
    }

    private void dfs(int[][] graph, int src, int target, List<Integer> current){
        if(src == target){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int n : graph[src]){
            current.add(n);
            dfs(graph,n, target, current);
            current.remove(current.size()-1);
        }
    }
}

// TC: O(V+E)
// SC: O(V)

