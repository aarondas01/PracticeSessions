class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        if (n==1)
            return true;
        if(n%2 ==0)
            return isPowerOfTwo(n/2);
        return false;
    }
}

// TC: O(logn)
// SC: O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0 || (Integer.lowestOneBit(n)!= n )){
            return false;

        }
        return true;
    }
}

//TC: O(1)
//SC: O(1)