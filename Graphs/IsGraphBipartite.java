class Solution {
    public boolean isBipartite(int[][] graph) {
        //graph coloring algorithm

        //DFS
        int len = graph.length;
        int[] color = new int[len];

        Arrays.fill(color,-1);

        for(int i = 0; i < len ; i++){
            if(color[i] == -1){
                color[i] = 1;
                if(!dfs(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int index, int[][] graph, int[] color){
        int currentColor = color[index];

        for(int idx :graph[index]){
            if(color[idx] == currentColor){
                return false;
            }
            if(color[idx] == -1){
                color[idx] = 1- currentColor;
                // if(currentColor == 1){
                //     color[idx] = 0;
                // }
                // if(currentColor == 0){
                //     color[idx] = 1;
                // }
                if(!dfs(idx, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
}

// TC: O(n^2)
// SC: O(n)


class Solution {
    public boolean isBipartite(int[][] graph) {
        //graph coloring
        //BFS
        int n = graph.length;
        int[] color  = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(color[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] =1;


                while(!queue.isEmpty()){
                    Integer node = queue.poll();
                    for(int index : graph[node]){
                        if(color[index] == color[node]){
                            return false;
                        }
                        else if(color[index] == 0){
                            queue.add(index);
                            color[index] = -color[node];
                        }
                    }
                }
            }
        }
        return true;
    }
}

// TC: O(n^2)
// SC: O(n)