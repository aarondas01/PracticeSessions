class Solution {
    public int largestIsland(int[][] grid) {
        //store the area associated with each island in a hashmap<position, area>

        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,0);

        int n = grid.length;
        int region =2;

        for(int i=0 ; i < n ; i++){
            for(int j=0; j< n ; j++){
                if(grid[i][j] ==1){
                    int area = getAreaAtPosition(grid, i, j, region);
                    map.put(region, area);
                    region++;
                }
            }
        }

        int maxArea = map.getOrDefault(2,0);

        for(int i = 0 ; i < n ; i++){
            for(int j= 0 ; j < n ; j++){
                if(grid[i][j] ==0){
                    //use set to eliminate dupplicate adding the same island again
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i-1][j]: 0);
                    set.add(j > 0 ? grid[i][j-1]: 0);
                    set.add(i < n-1 ? grid[i+1][j]: 0);
                    set.add(j < n-1 ? grid[i][j+1]: 0);

                    int totalArea = 1;
                    for(int id : set){
                        totalArea += map.get(id);
                    }

                    maxArea = Math.max(maxArea,totalArea);



                }
            }
        }
        return maxArea;
    }

    private int getAreaAtPosition(int[][] grid, int i , int j , int region){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = region;

        int sum =1;

        sum += getAreaAtPosition(grid,i,j+1, region);
        sum += getAreaAtPosition(grid,i+1,j, region);
        sum += getAreaAtPosition(grid,i,j-1, region);
        sum += getAreaAtPosition(grid,i-1,j, region);

        return sum;
    }
}

// TC: O(no of zeros *m*n) or O(n^2)
// SC: O(m*n)