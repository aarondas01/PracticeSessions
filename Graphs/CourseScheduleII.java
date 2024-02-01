class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //BFS
        //Topological Sort using BFS is called Kahn's  algorithm
        //build on course Schedule I

        //build graph
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //for building the adjacency list add an empty list to each key in map
        for(int i = 0 ; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        //indegree is required in Kahn's algo
        int indegree[] = new int[numCourses];

        for(int[] req : prerequisites){
            int a = req[0];
            int b = req[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        return topologicalSort(adj,numCourses,indegree);


    }

    private int[] topologicalSort(Map<Integer, List<Integer>> adj, int numCourses, int[] indegree){

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        //this index is for adding values to the result array
        int index = 0;

        int count = 0;

        //add to queue when indegree becomes 0
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){
                count++;
                result[index++]= i;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();

            //get the list of neighbors for each node(key) in the adj list
            List<Integer> neighbors = adj.getOrDefault(curr,new ArrayList<>());
            for(int v: neighbors){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    result[index++]=v;
                    queue.offer(v);
                }
            }
        }

        if(count == numCourses){
            return result;
        }
        //we had a cycle and we could not complete all courses
        return new int[]{};

    }
}

// TC: O(V+E)
// SC: O(V+E)


class Solution {

    //flag to check is there is a cycle or not
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //DFS

        //build graph

        Map<Integer,List<Integer>> adj = new HashMap<>();

        //for building the adjacency list add an empty list to each key in map
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

        //stack for dfs topo sort
        Stack<Integer> stack = new Stack<>();


        for(int i = 0 ; i < numCourses; i++){
            if(!visited[i]){
                dfs(adj, i , visited, pathVis, stack);
            }
        }



        //if there is a cycle return empty array
        if(hasCycle){
            return new int[]{};
        }



        //else return the result of topological sort  array
        int[] result = new int[numCourses];
        //this index is just for the indexing result array
        int index = 0;

        while(!stack.isEmpty()){
            result[index++] = stack.pop();
        }

        return result;

    }

    private void dfs(Map<Integer,List<Integer>> adj, int u ,  boolean[] visited,  boolean[] pathVis, Stack<Integer> stack ){
        visited[u] = true;
        pathVis[u] = true;

        //get the neighbors
        //get the list of neighbors for each node(key) in the adj list
        List<Integer> neighbors = adj.getOrDefault(u,new ArrayList<>());

        for(int v : neighbors){
            if(!visited[v]){

                dfs(adj,v,visited,pathVis,stack);
            }
            if(pathVis[v]){
                hasCycle = true;
                return;
            }
        }
        stack.push(u);
        pathVis[u] = false;

    }
}

// TC: O(V+E)
// SC: O(v+E)