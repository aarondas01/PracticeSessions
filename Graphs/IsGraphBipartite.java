class Solution {
    public boolean isBipartite(int[][] graph) {
        //DFS

        //odd length cycle is never bipartite
        //even length cycle is always bipartite

        //using graph coloring
        //red =1 green = 0

        int n = graph.length;

        //this color array acts as the visited array
        // -1 means uncolored , 1 means red and 0 means blue
        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                //we are starting with colring red to the first
                if(!dfs(graph, i, color,1)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean dfs(int[][] graph, int curr, int[] color, int currColor){
        color[curr] = currColor;
        for(int v : graph[curr]){
            //if neighbor's color is same as current color
            if(color[v] == color[curr]){
                return false;
            }
            //if the neighbor is not yet colored
            if(color[v] == -1){
                //this is same as reversing the currentColor
                // if currColor == 1, then color[v]= 0 and vice versa
                int colorOfV = 1- currColor;
                if(!dfs(graph,v,color,colorOfV)){
                    return false;
                }
            }

        }
        return true;
    }
}

// TC: O(V+E)
// sC: O(V+E)



class Solution {
    public boolean isBipartite(int[][] graph) {
        //BFS
        //graph coloring

        int n = graph.length;

        //this color array also acts as visited array
        int[] color = new int[n];
        //initially no one is colored
        Arrays.fill(color,-1);

        //red= 1, green = 0

        for(int i = 0 ; i < n ; i++){
            if(color[i]== -1){
                //starting the first node color as red
                if(!bfs(graph,i,color,1)){
                    return false;
                }

            }
        }
        return  true;

    }

    private boolean bfs(int[][] graph, int curr, int[] color, int currColor){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        color[curr] = currColor;

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : graph[u]){
                //if neighbor's color is same as current color
                if(color[v] == color[u]){
                    return false;
                }
                //if the neighbor is not yet colored
                if(color[v] == -1){
                    color[v] = 1 - color[u];
                    queue.offer(v);
                }
            }
        }
        return true;

    }
}

// TC: O(V+E)
// SC: O(V+E)