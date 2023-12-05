class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];

        int[][] directions = new int[][]{{-1,-1}, {-1,0},{-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n ;j++){
                int count = 0;
                for(int[] dir : directions){
                    int r = i + dir[0];
                    int c = j + dir[1];


                    if(r>= 0 && r< m && c >= 0 && c< n && board[r][c] == 1){
                        count++;
                    }
                }

                //initially all the cells are empty so first condition is not checked
                if(board[i][j] == 1){
                    // Any live cell with two or three live neighbors lives
                    if(count == 2 || count  ==3){
                        dp[i][j] = 1;
                    }

                }
                else{
                    //exactly three live neighbors becomes a live cell
                    if(count == 3){
                        dp[i][j] = 1;
                    }
                }
            }

        }
        //copy the values to the original matrix
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n;j++){
                board[i][j] = dp[i][j];
            }
        }
    }
}

// TC:O(m*n)
// SC: O(m*n)



class Solution {
    public void gameOfLife(int[][] board) {

        //inplace
        int m = board.length;
        int n = board[0].length;
        int[][] directions = new int[][]{{-1,-1}, {-1,0},{-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n ;j++){
                int count = 0;
                for(int[] dir : directions){
                    int r = i + dir[0];
                    int c = j + dir[1];


                    if(r>= 0 && r< m && c >= 0 && c< n && (board[r][c] == 1 || board[r][c] == 2)){
                        //board 1 or 2 mean either alive previous or alive currently
                        count++;
                    }
                }

                //initially all the cells are empty so first condition is not checked
                if(board[i][j] == 1){
                    // live cell with more than three and less than two live neighbors dies
                    if(count < 2 || count  > 3){
                        //update to dead to 2
                        //2 means it was alive previously and now dead
                        board[i][j] =2;
                    }

                }
                else{
                    //exactly three live neighbors becomes a live cell
                    if(count == 3){
                        //3 means it was dead previously and now made alive
                        board[i][j] = 3;
                    }
                }
            }

        }

        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n;j++){
                //taking %2  where %2 = 0 means and  dead %2 = 1 or %2 = 3 means alive
                board[i][j] %=2;
            }
        }
    }
}

// TC:O(m*n)
// SC: O(1)