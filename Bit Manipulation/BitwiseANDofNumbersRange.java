class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0 ;
        while(right != left){
            left >>=1;
            right  >>=1;
            count++;
        }
        return right<<count;
    }
}
// TC: O(n)
// SC: O(1)


class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left){
            right = right & right-1;
        }
        return left&right;
    }
}

// TC: O(n)
// sc: O(1)


class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //Kerninghan Algorithm
        while(right > left){
            right &= (right-1);
        }
        return right;
    }
}

// TC: O(n)
// SC: O(1)