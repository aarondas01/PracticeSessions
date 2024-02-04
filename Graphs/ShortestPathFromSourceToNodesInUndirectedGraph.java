class Solution {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<m; i++) {
            int u  = edges[i][0];
            int v  = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{src, 0});
        dist[src]=0;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int dis = top[1];
            if(dist[node]>dis) dist[node] = dis;
            for(int nbr:adj.get(node)) {
                if(1+dis<dist[nbr]) {
                    dist[nbr]=1+dis;
                    pq.add(new int[]{nbr, dis+1});
                }
            }
        }
        for(int i=0; i<n; i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        return dist;
    }
}