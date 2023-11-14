class Solution {
    public int countVowelPermutation(int n) {
        long a =1, e =1 , i = 1, o = 1 , u =1;

        int mod =1000000007;

        for(int k =1; k < n ;k++){
            long newa = (e+i+u)%mod;
            long newe = (a+i)%mod;
            long newi = (e+o)%mod;
            long newo = (i)%mod;
            long newu = (i+o)%mod;

            a= newa;
            e = newe;
            i =  newi;
            o = newo;
            u = newu;
        }
        return(int)((a+e+i+o+u)%mod);
    }
}
// TC: O(n)
// SC:O(1)


class Solution {

    //map for memoization
    private Map<String,Long> map = new HashMap<>();
    private int mod = 1000000007;
    public int countVowelPermutation(int n) {
        long total = 0;
        char[] charSet = new char[]{'a','e','i','o','u'};
        for(char c : charSet){
            total = (total + helper(n-1,c))%mod;
        }
        return (int)(total);
    }

    public long helper(int remainingChar, char prevChar){
        if(remainingChar == 0){
            return 1;
        }
        String key =  " " + remainingChar + prevChar;
        if(map.containsKey(key)){
            return map.get(key);
        }
        long total  =0;

        switch (prevChar){
            case 'a':
                total = helper(remainingChar-1,'e')%mod;
                break;
            case 'e':
                total = (helper(remainingChar-1,'a') + helper(remainingChar-1,'i'))%mod;
                break;
            case 'i':
                total = (helper(remainingChar-1,'a') + helper(remainingChar-1,'e')+ helper(remainingChar-1,'o') + helper(remainingChar-1,'u'))%mod;
                break;
            case 'o':
                total = (helper(remainingChar-1,'i') + helper(remainingChar-1,'u'))%mod;
                break;
            case 'u':
                total = (helper(remainingChar-1,'a'))%mod;
                break;

        }
        map.put(key,total);
        return total;
    }
}
// TC: O(n)
// SC: O(1)