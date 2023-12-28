class Solution {
    public int findComplement(int num) {
        int prod = 1;
        int res = 0;

        while(num != 0){
            int binaryRep = num %2 == 0 ? 1 : 0;
            num = num/2;
            res = binaryRep * prod + res;
            prod *=2;
        }
        return res;
    }
}

// TC: O(1)
// SC: O(1)

class Solution {
    public int findComplement(int num) {
        int res =0;
        int prod = 0;
        while(res < num){
            res += Math.pow(2,prod);
            prod++;
        }
        return res-num;
    }
}

// TC: O(1)
// SC: O(1)