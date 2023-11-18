class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char i[]: board){
            Arrays.fill(i,'.');
        }
        return dfs(0,board);
    }

    private int dfs(int col, char[][] board){
        if(col == board.length){
            return 1;
        }
        int count = 0;
        for(int row = 0 ; row < board.length; row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                count += dfs(col+1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private boolean isSafe(int row, int col, char[][] board){
        //horizontal
        for(int j = 0 ; j < board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int i = 0 ; i < board[0].length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upper left
        int r = row;
        for(int c = col; c >=0 && r >=0; c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //upper right
        r = row;
        for(int c = col; c < board.length && r >=0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower left
        r= row;
        for(int c =col; r < board.length && c >= 0; r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right
        r=row;
        for(int c = col ; r < board.length && c < board.length; r++,c++){
            if(board[r][c] ==  'Q'){
                return false;
            }
        }

        return true;

    }
}

// TC: O(n*n!)
// sC: O(n^2)


class Solution {
    public int totalNQueens(int n) {
        //copy of N Queens I and just return the size
        //TC and SC remain same
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        backtrack(board, result,0);
        return result.size();
    }

    public void backtrack(char[][] board, List<List<String>> result, int col){

        if(col == board.length){
            saveBoard(board,result);
            return;
        }
        for(int row = 0; row <board.length; row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                backtrack(board,result,col+1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){
        //horizontal
        for(int j = 0 ; j < board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int i = 0 ; i < board[0].length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upper left
        int r = row;
        for(int c = col; c >=0 && r >=0; c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //upper right
        r = row;
        for(int c = col; c < board.length && r >=0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower left
        r= row;
        for(int c =col; r < board.length && c >= 0; r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right
        r=row;
        for(int c = col ; r < board.length && c < board.length; r++,c++){
            if(board[r][c] ==  'Q'){
                return false;
            }
        }

        return true;

    }

    private void saveBoard(char[][] board, List<List<String>> result){
        String row = "";
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < board.length;i++){
            row="";
            for(int j = 0 ;j < board[0].length;j++){
                if(board[i][j] == 'Q'){
                    row +="Q";
                }
                else{
                    row +=".";
                }
            }
            list.add(row);
        }
        result.add(list);
    }
}
// TC: (n*n)
// SC: O(n*n)