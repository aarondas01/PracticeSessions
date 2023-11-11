Smallest String With A Given Numeric Value

class Solution {
    public String getSmallestString(int n, int k) {
        //greedy approach
        char[] c = new char[n];
        for(int i = n-1; i >=0 ; i--){
            int val = Math.min(26,k-i);
            c[i] = (char)(val-1 + 'a');
            k = k-val;
        }
        return String.valueOf(c);
    }
}
// TC: O(n)
// SSC: O(n)