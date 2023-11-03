Sum of Square Numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        //two pointer approach
        long left = 0 , right = (long)Math.sqrt(c);

        while(left <= right){
            long total = left*left + (right*right);
            if(total == c){
                return true;
            }
            else if(total < c){
                left++;
            }
            else{
                right--;
            }
        }

        return false;
    }
}

// TC: O(n)
// SC: O(1)