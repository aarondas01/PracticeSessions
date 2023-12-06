class Solution {
    public int lengthOfLIS(int[] nums) {
        //patience sort using treeset

        //using treeset sc O(1)
        TreeSet<Integer> treeset = new TreeSet<>();
        for(int n : nums){
            //val is higher or equal value
            Integer val = treeset.ceiling(n);
            if(val == null){
                treeset.add(n);
            }
            else{
                treeset.remove(val);
                treeset.add(n);
            }
        }
        return treeset.size();
    }
}

// TC: O(nlogn)
// SC: O(1)

class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp using binary search
        int[] dp = new int[nums.length];

        int  k =0;
        dp[k] = nums[0];

        for(int i=1; i < nums.length; i++){
            if(nums[i] < dp[k]){
                int start = 0 ;
                int end = k;

                while(start <= end){
                    int mid = (start+end)/2;
                    if(dp[mid] < nums[i]){
                        start = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
                dp[start]= nums[i];
            }
            else if(nums[i] != dp[k]){
                k++;
                dp[k] = nums[i];
            }
        }
        return k+1;
    }
}

// TC: O(nlogn)
// SC: O(n)

