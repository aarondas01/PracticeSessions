class Solution {
    public int numDecodings(String s) {
        //using dp

        long[] dp = new long[s.length()+1];

        dp[0] = 1;
        dp[1] = decodeChar(s.charAt(0));

        for(int i =2; i<= s.length() ; i++){
            char oneDigit = s.charAt(i-2);
            char twoDigit = s.charAt(i-1);

            dp[i] += dp[i-1] * decodeChar(twoDigit);

            dp[i] += dp[i-2] * decodeTwoChars(oneDigit,twoDigit);

            dp[i] = dp[i] % 1000000007;
        }
        return (int) dp[s.length()];
    }

    private int decodeChar(char c){
        if(c== '*'){
            return 9;

        }
        else if(c =='0'){
            return 0;
        }
        return 1;
    }


    private int decodeTwoChars(char c1, char c2){
        switch(c1){
            case '*':
                if(c2 == '*'){
                    return 15;
                }
                else if(c2 >='0' && c2 <= '6'){
                    return 2;
                }
                else{
                    return 1;
                }
            case '1':
                if(c2 == '*'){
                    return 9;
                }
                else{
                    return 1;
                }
            case '2':
                if(c2 =='*'){
                    return 6;
                }
                else if(c2 >= '0' && c2 <= '6'){
                    return 1;
                }
                else{
                    return 0;
                }
            default:
                return 0;
        }
    }
}

// TC: O(n)
// SC: O(n)