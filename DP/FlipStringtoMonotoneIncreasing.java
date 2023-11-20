
class Solution {
    public int minFlipsMonoIncr(String s) {
        int zeroToOne = 0 , oneCount = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                if(oneCount == 0){
                    continue;
                }
                else{
                    zeroToOne++;
                }
            }
            else{
                oneCount++;
            }
            if(zeroToOne> oneCount){
                zeroToOne = oneCount;
            }
        }
        return zeroToOne;
    }
}


// TC: O(n)
// SC: O(1)

class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount  = 0 , zerosToOne = 0;

        //find the point where the first one occurs
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }

        for(;i < s.length(); i++){
            if(s.charAt(i) =='1'){
                oneCount++;
            }
            else{
                zerosToOne++;
            }

            if(zerosToOne > oneCount){
                zerosToOne = oneCount;
            }
        }
        return zerosToOne;
    }
}

// TC: O(n)
// SC: O(1)

