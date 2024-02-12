class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        int k = n-2;

        for(int i = n-1;  i>0 ; i--){
            if(nums[i] <= nums[i-1]){
                k--;
            }
            else{
                break;
            }
        }
        if(k==-1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i = n-1; i > 0 ; i--){
            if(nums[i] > nums[k]){
                swap(nums,i,k);
                break;
            }
        }
        reverse(nums, k+1,n-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// TC: O(n)
// SC: O(1)