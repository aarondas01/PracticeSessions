class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[S] = 0;
        pq.offer(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int dist = edge.get(1);
                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[]{d + dist, adjNode});
                }
            }
        }

        return result;
    }
}
