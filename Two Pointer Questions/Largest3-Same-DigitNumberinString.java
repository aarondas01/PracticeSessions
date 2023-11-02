class Solution {
    public String largestGoodInteger(String num) {
        int digit  = -1;
        for(int i = 0 ; i < num.length()-2; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) ==num.charAt(i+2)){
                digit = Math.max(digit,num.charAt(i)- '0');
            }
        }
        if(digit == -1){
            return "";
        }
        else{
            return digit+""+digit+""+digit;
        }
    }
}
// TC: O(n)
// SC: O(1)