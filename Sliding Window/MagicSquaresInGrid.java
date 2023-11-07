class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        //conditions for Magic Square
        //Middle element must be 5
        //sum of all elements must be 45
        //sum of each row, each column and each diagonal must be 15

        int r = grid.length;
        int c = grid[0].length;
        int res = 0 ;

        for(int i = 0 ; i < r-2; i++){
            for(int j = 0 ; j < c-2; j++){
                if(grid[i+1][j+1] != 5){
                    continue;
                }
                if(checkMagic(grid,i,j)){
                    res++;
                }
            }
        }
        return res;
    }

    boolean checkMagic(int[][] grid , int top, int left){
        int sum = 0;
        for(int i = 0 ; i < 3; i++){
            sum+= grid[top+i][left+i];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i= 0 ; i <3; i++){
            int row = 0, col = 0 , dg = 0;
            for(int j =0; j < 3 ; j++){
                if(grid[top+i][left+j] > 9 || grid[top+i][left+j] < 1)
                    return false;

                set.add(grid[top+i][left+j]);
                dg += grid[top+j][left +2 -j];
                row += grid[top+i][left+j];
                col += grid[top+j][left +i];
            }
            if(dg != sum || row != sum || col != sum){
                return false;
            }

        }
        return set.size() == 9;
    }
}

// TC: O(r*c)
// SC: O(1)
