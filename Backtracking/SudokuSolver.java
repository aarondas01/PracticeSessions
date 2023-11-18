
class Solution {

    private boolean helper(char[][] board, int row, int col){

        if(row == board.length){
            return true;
        }
        int nrow = 0 ;
        int ncol = 0 ;

        if(col == board.length -1){
            nrow = row+1;
            ncol = 0;
        }
        else{
            nrow = row;
            ncol = col+1;
        }

        if(board[row][col] != '.'){
            if(helper(board,nrow,ncol)){
                return true;
            }
        }
        else{
            //fill the place
            for(int i = 1 ;  i <= 9; i++){
                if(isSafe(board,row,col,i)){
                    board[row][col] = (char)(i + '0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }
                    else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);

    }

    private boolean isSafe(char[][] board, int row, int col, int number){
        //row and column
        for(int i = 0 ; i < board.length; i++){
            if(board[i][col] == (char)(number + '0')){
                return false;
            }
            if(board[row][i] == (char)(number + '0' )){
                return false;
            }
        }

        //grid

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i =startRow ; i < startRow+3; i++){
            for(int j = startCol ; j < startCol+3; j++){
                if(board[i][j] == (char)(number + '0')){
                    return false;
                }
            }
        }
        return true;
    }
}

// TC: O(n^2)
//SC: O(n)


