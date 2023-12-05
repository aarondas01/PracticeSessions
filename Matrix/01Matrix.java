class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];

        int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = -1;
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for(int[] dir : directions){
                int px = x + dir[0];
                int py = y + dir[1];

                if(px >= 0 && px < m && py >= 0 && py < n && result[px][py] == -1){
                    result[px][py] = result[x][y] +1;
                    queue.add(new int[]{px,py});
                }
            }
        }
        return result;
    }
}

// TC: O(m*n)
// SC: O(m*n)


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //without using extra space


        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {{0,-1},{0,1}, {-1,0},{1,0}};

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for(int[] dir : directions){
                int px= x+dir[0];
                int py = y + dir[1];

                if(px>= 0 && px < m && py >= 0 && py < n && mat[px][py] ==-1){
                    mat[px][py] = mat[x][y] +1;
                    queue.add(new int[]{px,py});
                }
            }
        }
        return mat;

    }
}

// TC O(m*n)
// SC:O(n)