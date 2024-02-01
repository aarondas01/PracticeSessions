class Solution {
    public void rotate(int[][] matrix) {


        for(int r = 0 ; r < matrix.length ; r++){
            for(int c = 0 ; c < r ; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        int fc = 0 ;
        int lc = matrix[0].length -1;

        while(fc < lc){
            for(int r = 0 ; r < matrix.length; r++){
                int temp = matrix[r][fc];
                matrix[r][fc] = matrix[r][lc];
                matrix[r][lc] = temp;
            }
            fc++;
            lc--;
        }
    }
}

// TC: O(n^2)
// SC: O(1)


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i =0 ; i < (n+1)/2; i++){
            for(int j = 0 ; j < n/2; j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i]= matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

// TC: O(n^2)
// SC: O(1)