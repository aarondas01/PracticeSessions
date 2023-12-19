class Solution {
    public int shortestPathLength(int[][] graph) {
        //try BFS in every node
        // In BFS we donot visit same node again but here we can reuse edges
        //to check visited node use bit manipulation
        //visited <node,bit state>

        if(graph.length ==1){
            return 0;
        }

        int finalState = (1 << graph.length)-1;

        Queue<int[]> queue = new LinkedList<>();

        //add all nodes intially because we can start anywhere
        for(int i = 0 ; i < graph.length; i++){
            queue.add(new int[]{i, 1 <<i});
        }

        // [no of many nodes][each node may have 2^n visited bit]
        int[][] visitedMap = new int[graph.length][finalState+1];

        int shortestPath = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            shortestPath++;
            for(int i = 0 ; i < size; i++){
                int[] head = queue.poll();
                int nodeId = head[0];
                int visitedNodeBitState = head[1];

                for(int neighbor  : graph[nodeId]){
                    int newVisitedNodeBitState = visitedNodeBitState | (1<< neighbor);
                    //if the same node was visited again with same visitedNodeBitState.
                    //it means this node can be skipped
                    if(visitedMap[neighbor][newVisitedNodeBitState] ==1){
                        continue;
                    }
                    visitedMap[neighbor][newVisitedNodeBitState] =1;
                    if(newVisitedNodeBitState == finalState){
                        return shortestPath;
                    }
                    queue.add(new int[] {neighbor, newVisitedNodeBitState});
                }
            }
        }


        return -1;
    }
}

// TC: O(n* 2^n)
// SC: O(n* 2^n)