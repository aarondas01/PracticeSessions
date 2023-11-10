class Solution {
    public int maxArea(int[] height) {
        //two pointers
        int left = 0, right = height.length -1;
        int area = 0, maxArea = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                area = height[left] * (right-left);
                left++;
            }
            else{
                area = height[right] * (right-left);
                right--;
            }
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
// TC: O(N)
// SC: O(1)
