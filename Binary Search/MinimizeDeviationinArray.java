class Solution {
    public int minimumDeviation(int[] nums) {
        //make all odd values even
        //take minimum of all values
        //find max and difference and update max/2 till the max is even
        //otherwise the difference is the result

        //using treeset

        TreeSet<Integer> set = new TreeSet<>();
        for(int n : nums){
            if(n%2 != 0){
                set.add(n*2);
            }
            else{
                set.add(n);
            }
        }

        int diff = Integer.MAX_VALUE;
        while(true){
            int maxVal = set.last();
            int minVal = set.first();
            int currDiff = maxVal-minVal;
            diff = Math.min(diff, currDiff);

            if(maxVal % 2 == 0){
                set.remove(maxVal);
                set.add(maxVal/2);
            }
            else{
                return diff;
            }
        }
    }
}

// TC: O(logn*logm)
// SC: O(n)