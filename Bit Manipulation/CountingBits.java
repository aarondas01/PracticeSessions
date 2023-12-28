class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        res[0] = 0;

        for(int i =1; i <= n ; i++){
            if(i%2 !=0){
                res[i] = res[i/2]+1;
            }
            else{
                res[i] = res[i/2];
            }
        }
        return res;
    }
}

//TC: O(n)
//SC: O(n)


class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<= n ; i++){
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
}

// TC:O(n)
// SC: O(n)

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i = 0 ; i <=n ; i++){
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
// TC: O(n)
// SC: O(n)