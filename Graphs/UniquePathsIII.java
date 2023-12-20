
class Solution {
    public int uniquePathsIII(int[][] grid) {
        // find non obstacle count
        //find starting point
        //backtracking and move in all directions
        //mark visited squares with -1
        int m = grid.length;
        int n = grid[0].length;

        int nonObstacles = 0;
        int startX = 0 ;
        int startY = 0;

        for(int i = 0 ; i <m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] ==0){
                    nonObstacles++;
                }
                else if(grid[i][j] ==1){
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(grid, nonObstacles, startX, startY);
    }

    private int dfs(int[][] grid , int nonObstacles, int startX, int startY){
        if(startX < 0 || startY < 0 || startX >= grid.length || startY >= grid[0].length || grid[startX][startY] == -1){
            return 0 ;
        }
        if(grid[startX][startY] == 2){
            return nonObstacles == -1 ? 1 : 0;
        }
        grid[startX][startY] = -1;
        nonObstacles--;

        int totalPaths = dfs(grid, nonObstacles, startX+1, startY )+
                dfs(grid, nonObstacles, startX-1, startY )+
                dfs(grid, nonObstacles, startX, startY+1 )+
                dfs(grid, nonObstacles, startX, startY-1 );

        grid[startX][startY] = 0;
        nonObstacles++;

        return totalPaths;


    }
}

// TC: O(m*n)
// SC: O(m*n)