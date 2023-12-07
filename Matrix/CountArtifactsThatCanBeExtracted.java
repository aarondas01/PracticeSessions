class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] uncovered = new boolean[n][n];

        for(int[] d : dig){
            uncovered[d[0]][d[1]] = true;
        }

        int count  = 0 ;

        for(int art[] : artifacts){
            boolean extracted = true;
            for(int i =  art[0]; i <= art[2]; i++){
                for(int j = art[1] ; j <= art[3]; j++){
                    if(!uncovered[i][j]){
                        extracted = false;
                        break;
                    }

                }
            }
            if(extracted) count++;
        }
        return count;

    }
}

// TC: O(m*n)
// SC: O(n)
