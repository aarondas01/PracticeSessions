class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ;  j < grid[i].length; j++){
                if(grid[i][j] ==1){
                    //top
                    if(i == 0 || grid[i-1][j] == 0){
                        count++;
                    }
                    //left
                    if(j==0 || grid[i][j-1] ==0){
                        count++;
                    }
                    //bottom
                    if(i == grid.length-1 || grid[i+1][j] ==0){
                        count++;
                    }
                    //right
                    if( j == grid[0].length-1 || grid[i][j+1] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

// TC: O(m*n)
// SC: O(1)


class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null){
            return 0;
        }
        for(int i= 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] ==1){
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }

    private int getPerimeter(int[][] grid, int i, int j){
        if(i <0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 1;
        }
        if(grid[i][j]==0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }

        int perimeter = 0;

        grid[i][j] = -1;
        perimeter += getPerimeter(grid,i-1,j);
        perimeter += getPerimeter(grid,i,j-1);
        perimeter += getPerimeter(grid,i+1,j);
        perimeter += getPerimeter(grid,i,j+1);

        return perimeter;

    }
}

// TC: O(m*n)
// SC: O(1)