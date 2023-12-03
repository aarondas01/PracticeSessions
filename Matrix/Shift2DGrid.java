class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m*n;
        k = k%total;

        List<List<Integer>> res = new ArrayList<>();

        for(int i =0 ; i < m ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                int index = findIndex(i, j , n, k , total);
                list.add(grid[index/n][index%n]);

            }
            res.add(list);
        }
        return res;
    }

    private int findIndex(int  i , int j  , int col , int k, int total){
        int index = (i*col + j + total - k )% total;
        return index;
    }
}
// TC: O(n^2)
// SC: O(n)

