class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        Set<Integer> set1, set2;

        for(int i = 0 ; i < n ; i++){
            set1 = new HashSet<>();
            set2 = new HashSet<>();

            for(int j = 0 ; j< n ; j++){
                set1.add(matrix[i][j]);
                set2.add(matrix[j][i]);
            }
            if(set1.size() != n || set2.size() != n){
                return  false;
            }
        }
        return true;
    }
}

// TC: O(n^2)
// SC: O(n)


class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        int sum = 0 ;
        for(int i=1; i <= n; i++){
            sum^=i;
        }

        for(int i = 0 ; i < n; i++){
            int rowXor = sum ;
            int colXor = sum ;
            for(int j =0 ; j < n ; j++){
                rowXor ^= matrix[i][j] ;
                colXor ^= matrix[j][i] ;
                if(j+1 < matrix[0].length){
                    if(matrix[i][j] == matrix[i][j+1]){
                        return false;
                    }
                }
            }
            if(rowXor !=0 || colXor != 0){
                return false;
            }
        }
        return true;
    }
}

// TC: O(n^2)
// SC: O(n)