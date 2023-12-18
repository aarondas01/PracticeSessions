class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 0 && n == 1)
            return 1;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                int i = q.peek()[0];
                int j = q.poll()[1];
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x == n || y < 0 || y == n)
                        continue;
                    if (grid[x][y] != 0 || seen[x][y])
                        continue;
                    if (x == n - 1 && y == n - 1)
                        return ans + 1;
                    q.offer(new int[] {x, y});
                    seen[x][y] = true;
                }
            }
        }

        return -1;
    }

}

// TC: O(m*n)
// SC: O(m*n)


class Solution {

    private class Point {
        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length -1;
        if(grid[0][0] == 1|| grid[n][n] ==1){
            return -1;
        }

        int level = 0;
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0,0));

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                Point p = queue.poll();
                int x = p.x;
                int y = p.y;

                if(x== n && y == n){
                    return level+1;
                }

                if(x <0 || y < 0 ||  x > n || y > n || grid[x][y] >=1){
                    continue;
                }

                grid[x][y] = 2;
                queue.offer(new Point(x-1,y));
                queue.offer(new Point(x-1,y+1));
                queue.offer(new Point(x,y+1));
                queue.offer(new Point(x,y-1));
                queue.offer(new Point(x+1,y));
                queue.offer(new Point(x+1,y+1));
                queue.offer(new Point(x-1,y-1));
                queue.offer(new Point(x+1,y-1));



            }
            level++;
        }
        return -1;
    }
}