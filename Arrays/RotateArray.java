class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        //if k is negative
        if(k < 0){
            k +=n;
        }

        reverse(nums, 0, n-k-1);
        reverse(nums,n-k, n-1);
        reverse(nums, 0,n-1);
    }

    private void reverse(int[] nums, int i, int j){
        int start =i;
        int end = j;

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;

            start++;
            end--;
        }
    }
}

// TC: O(n)
// SC: O(1)



class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            res[(i+k)%n] = nums[i];
        }

        for(int i = 0 ; i < n ;i++){
            nums[i] = res[i];
        }
    }
}

// TC: O(n)
// SC: O(n)