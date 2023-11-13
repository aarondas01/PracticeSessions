class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length+1];
        for(int i=1; i <= nums.length; i++){
            prefixSum[i] = prefixSum[i-1]+ nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1]- prefixSum[left];
    }
}

//  TC: O(n)
// SC: O(n)

class NumArray {
    //brute force
    private int[] numArray ;

    public NumArray(int[] nums) {
        this.numArray = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += numArray[i];
        }
        return sum;
    }
}

//  TC: O(k*n)
//  SC: O(n)