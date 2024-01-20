class Solution {
    public int maxPoints(int[][] points) {
        //brute force


        int n = points.length;

        if(n<=2){
            return n;
        }

        int ans  =2;
        for(int i= 0 ; i < n; i++){
            for(int j = i+1; j < n ; j++){
                int temp =2;

                int dx =  points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                for(int k = 0 ; k < n ; k++){
                    if(k != i && k != j){
                        int dx_ = points[k][0]- points[i][0];
                        int dy_ = points[k][1] - points[i][1];

                        //cross multiplication
                        if(dy * dx_ == dx * dy_){
                            temp++;
                        }
                    }
                }
                if(temp > ans){
                    ans = temp;
                }

            }
        }

        return ans;
    }
}

// TC: O(n^3)
// SC: O(1)



class Solution {
    public int maxPoints(int[][] points) {
        int max  =1;
        for(int i = 0 ; i < points.length; i++){
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j = 0 ; j < points.length; j++){
                if(i==j){
                    continue;
                }
                double slope = (points[j][0]-points[i][0]) != 0 ? (points[j][1]-points[i][1])*1.0/(points[j][0]-points[i][0]) : Integer.MAX_VALUE;
                map.put(slope,map.getOrDefault(slope,1)+1);
                max = Math.max(max, map.get(slope));
            }
        }
        return max;
    }
}

// TC: O(n)
// SC: O(n)