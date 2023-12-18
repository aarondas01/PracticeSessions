class Solution {
    public int minimumEffortPath(int[][] heights) {
        //dijkstra's algorithm
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,0,0});

        // int[] = {dist, row, col}

        int[][] directions = {{0,-1}, {0,1}, {1,0}, {-1,0}};

        while(!pq.isEmpty()){
            int[] min = pq.poll();
            int dist = min[0];
            int xPos = min[1];
            int yPos = min[2];

            if(dist > effort[xPos][yPos])
                continue;
            if(xPos == m-1 && yPos == n-1){
                return dist;
            }

            for(int[] dir : directions){
                int newRow = xPos + dir[0];
                int newCol = yPos + dir[1];

                if(newRow >= 0 && newRow <m && newCol >= 0 && newCol <n){
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[xPos][yPos]));
                    if(newDist < effort[newRow][newCol]){
                        effort[newRow][newCol]= newDist;
                        pq.offer(new int[]{newDist, newRow,newCol});
                    }
                }
            }

        }
        return 0;
    }
}

// TC: O(m*n * log(m*n))
// SC: O(m*n)


class Solution {
    int[][] directions= {{0,-1},{0,1}, {-1,0}, {1,0}};
    public int minimumEffortPath(int[][] heights) {
        //using binary search

        int start = 0 , end = 1000000;

        int m = heights.length;
        int n = heights[0].length;

        while(start < end){
            int mid = start + (end-start)/2;

            boolean[][] visited = new boolean[m][n];

            if(isPath(heights,0,0,mid,visited,heights[0][0])){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    private boolean isPath(int[][] heights, int x, int y, int k, boolean[][] visited, int val){
        if(x < 0 || y < 0 || x >= heights.length || y >=  heights[0].length || visited[x][y] || Math.abs(val - heights[x][y]) > k){
            return false;
        }

        if(x == heights.length -1 && y == heights[0].length-1){
            return true;
        }
        visited[x][y] = true;

        for(int[] dir : directions){
            if(isPath(heights, x+dir[0], y+ dir[1], k, visited, heights[x][y])){
                return true;
            }
        }
        return  false;
    }

}

// TC: O(m*n log(max))
// SC: O(m*n)
