
class Solution {
    public int countVowelStrings(int n) {
        //using dp

        int [][] dp = new int[n+1][6];

        for(int i =1; i <=n; i++){
            for(int j = 1 ; j<=5; j++){
                if(i >1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else{
                    dp[i][j] = 1 + dp[i][j-1];
                }
            }
        }
        return dp[n][5];
    }
}

// TC: O(5n)
// SC: O(6n)

class Solution {
    char[] vowels = new char[]{ 'a', 'e', 'i', 'o', 'u'};
    public int countVowelStrings(int n) {
        //backtracking
        int total = 0;
        for(char c : vowels){
            total += count(n-1,c);
        }
        return total;
    }

    private int count(int n , char lastChar){
        if(n==0){
            return 1;
        }
        int temp  = 0;
        for(char c : vowels){
            if(lastChar <= c){
                temp += count(n-1,c);
            }
        }
        return temp;
    }
}

// TC: O(5^n)
// SC: O(n)

class Solution {
    public int countVowelStrings(int n) {
        //using math formula
        // kCn = (n+k-1)!/(k!)(n-1)!
        //here k = 5
        return (n+4)*(n+3)*(n+2)*(n+1)/24;
    }
}
// TC: O(1)
// SC: O(1)