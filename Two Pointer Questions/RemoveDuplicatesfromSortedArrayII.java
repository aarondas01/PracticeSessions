class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        for(int n : nums){
            if(i<2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return n;
        int i = 2;
        for(int j = i ; j < n ; j++){
            if(nums[j] != nums[i-2]){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        int m =1 , count =1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){

                if(count <k){
                    nums[m++] = nums[i];
                }
                count++;
            }
            else{
                count  = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }
}
// TC: O(n)
// SC: O(1)