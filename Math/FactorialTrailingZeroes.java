class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >0){
            n /=5;
            count+=n;
        }
        return count;
    }
}
// TC: O(logn)

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int powerOfFive = 5;

        while(n >= powerOfFive){
            count += n/powerOfFive;
            powerOfFive *= 5;
        }
        return count;
    }
}

// TC: O(logn)