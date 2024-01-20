class Solution{
    static long isPallindrome(long N){
        // code here

        long temp = N;
        long reverse = 0;

        while(temp != 0){
            reverse <<= 1;
            if((temp&1)==1){
                reverse ^= 1;
            }
            temp >>=1;
        }
        if(N==reverse){
            return 1l;
        }
        return 0l;

    }
}

//TC: O(1)
//SC: O(1)