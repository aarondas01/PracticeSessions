class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS
        //Topological Sort using BFS is called Kahn's  algorithm

        //build graph
        Map<Integer,List<Integer>> adj = new HashMap<>();

        //for building the adjacency list add an empty list to each key in map
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        //indegree is required in Kahn's algo
        int[] indegree = new int[numCourses];

        for(int[] req : prerequisites){
            int  a = req[0];
            int  b = req[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        //if cycle is present then not possible
        return topologicalSort(adj,numCourses,indegree);

    }

    private boolean topologicalSort(Map<Integer,List<Integer>> adj,int numCourses, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        //count visited nodes
        int count = 0;

        //add to queue when indegree becomes 0
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] ==0){
                count++;
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()){
            int  curr = queue.poll();
            //get the list of neighbors for each node(key) in the adj list
            List<Integer> neighbors = adj.getOrDefault(curr, new ArrayList<>());

            for(int v : neighbors){
                indegree[v]--;
                if(indegree[v] ==0){
                    count++;
                    queue.offer(v);
                }
            }


        }
        if(count == numCourses){
            return true;
        }
        //cycle detected hence all coursess cannot be completed
        return false;
    }
}

// TC: O(n*m)
// SC: O(n*m)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //DFS

        //detect cycle in directed graph using DFS

        //build graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] req : prerequisites){
            int a = req[0];
            int b = req[1];

            adj.get(b).add(a);
        }


        boolean[] visited = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0 ; i < numCourses; i++){
            if(!visited[i] && isCycleDFS(adj,i, visited,pathVis)){
                //all courses cannot be completed
                // there is a cycle//
                //hence according to question you should return false
                return false;
            }
        }
        //all courses can be completed
        //since there is no cycle
        return true;
    }

    private static boolean isCycleDFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, boolean[] pathVis){
        visited[u] = true;
        pathVis[u] = true;


        //get the list of neighbors for each node(key) in the adj list
        List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());

        for(int v : neighbors){
            if(!visited[v]){
                visited[v] = true;
                pathVis[v] = true;
                boolean flag = isCycleDFS(adj, v, visited, pathVis);
                if(flag){
                    //there is cycle
                    return true;
                }
            }
            else if(pathVis[v] && visited[v]){
                //there is cycle
                return true;
            }
        }
        pathVis[u] = false;
        //no cycle
        return false;
    }
}

// TC: O(V+E)
// SC: O(V+E)
