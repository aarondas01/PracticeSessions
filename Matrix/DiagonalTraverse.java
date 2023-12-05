class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // odd sum of indices means downwards
        // even sum of indices means upwards

        int m = mat.length;
        int n = mat[0].length;
        if(  m==0){
            return new int[]{};
        }

        if(n == 0){
            return new int[]{};
        }

        int[] res = new int[m*n];

        int row  = 0 , col = 0;

        for(int i = 0 ; i < m*n; i++){
            res[i] = mat[row][col];

            if((row+col) %2==0){
                //even sum means upwards
                //row-- col++
                if(col == n-1){
                    row++;
                }
                else if(row == 0){
                    col++;
                }
                else{
                    row--;
                    col++;
                }
            }

            else{
                //odd sum means downwards
                //row++ col--
                if(row == m-1){
                    col++;
                }
                else if(col == 0){
                    row++;
                }
                else{
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}

// TC: O(m*n)
// SC: O(m*n)