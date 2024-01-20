class Solution {
    public int getSum(int a, int b) {
        if(a == 0)
            return b;
        if (b==0)
            return a;

        while(b!= 0){
            int carry = (a&b) <<1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}

// TC: O(1)
// SC: O(1)


class Solution {
    public int getSum(int a, int b) {
        //recursion

        return b == 0 ? a : getSum(a^b, (a&b) << 1);
    }
}

// TC: O(1)
// SC: O(1)