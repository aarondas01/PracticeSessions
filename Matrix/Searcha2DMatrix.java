class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length  == 0){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0 , end = row*col-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int r = mid/col;
            int c = mid%col;

            if(target == matrix[r][c]){
                return true;
            }
            else if(target > matrix[r][c]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}

// TC: O(logm*n)
// SC: O(1)