class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long A = a, B = b;
        long mod = (long)(Math.pow(10,9)+7);

        long left = Math.min(a,b) ;
        long right = (long)n * Math.min(a,b);

        while(B > 0){
            long temp = A;
            A = B;
            B = temp %B;
        }
        long lcm = (a*b)/A;
        while(left < right){
            long mid = (left + right)/2;
            if((mid/a) + (mid/b) - (mid/lcm) <n){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return (int) (left % mod);
    }
}

// TC: O(logn)
// SC: O(1)

