class Solution {
    public int candy(int[] ratings) {
        int sum = 0;

        int[] candies = new int[ratings.length];

        Arrays.fill(candies,1);

        //left to right
        for(int i =0; i < ratings.length -1; i++){
            if(ratings[i+1] > ratings[i]){
                candies[i+1] = candies[i]+1;
            }
        }

        //right to left
        for(int i = ratings.length-1; i >0 ; i--){
            if(ratings[i-1] > ratings[i]){
                if(candies[i-1] < candies[i]+1){
                    candies[i-1] = candies[i]+1;
                }
            }
        }

        for(int i = 0 ; i < candies.length; i++){
            sum += candies[i];
        }
        return sum;
    }
}

// TC: O(n)
// SC: O(n)