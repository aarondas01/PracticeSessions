class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        int[] circular = new int[n*2];

        for(int i  =0 ; i < n;i++){
            if(nums[i]== 1){
                totalOnes++;
            }
            circular[i] = nums[i];
            circular[n+i] = nums[i];
        }

        int start = 0 , end  = 0 ;
        //zero count in each window
        int zeroCount = 0;

        int minCount  = Integer.MAX_VALUE;
        while(end < totalOnes){
            if(circular[end] == 0){
                zeroCount++;
            }
            end++;
        }

        while(end< circular.length){
            if(circular[end] == 0){
                zeroCount++;
            }
            if(end-start+1 == totalOnes){
                zeroCount = Math.min(zeroCount,minCount);
            }
            else if(end-start+1 > totalOnes){
                if(circular[start] == 0){
                    zeroCount--;
                }
                minCount = Math.min(minCount,zeroCount);
                start++;
            }
            end++;
        }
        return minCount;


    }
}
// TC: O(n)
// SC: O(n)