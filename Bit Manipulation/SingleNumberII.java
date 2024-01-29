class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int k = 0 ; k <= 31; k++){
            //left shift
            int temp = (1<<k);

            int countZeros = 0;
            int countOnes = 0;

            for(int n : nums){
                //find if kth bit is 0 or 1
                if((n&temp)==0){
                    countZeros++;
                }
                else{
                    countOnes++;
                }
            }

            if(countOnes %3 ==1){
                //OR operation with each left shift
                result = (result | temp);
            }
        }
        return result;
    }
}

// TC: O(32*n)
// SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int once  = 0 , twice = 0;

        for(int n : nums){
            once = (once^n) & ~(twice);
            twice = (twice^n) & ~(once);
        }
        return once;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int ones  = 0 , twos = 0, threes = 0;

        for(int n : nums){

            //twice
            twos |= ones & n;

            //once
            ones ^= n;

            //thrice
            threes = ones & twos;

            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums.length ==1){
            return nums[0];
        }

        if(nums[0] != nums[1]){
            return nums[0];
        }

        for(int i = 0 ; i < nums.length-1; i+=3){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

// TC: O(nlogn *n)
// SC: O(1)