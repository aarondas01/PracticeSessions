class Solution {
    public long smallestNumber(long num) {
        //check if number is negative or not
        //convert it into char array
        //if positive
        //sort the char array
        //swap the first non zero digit with the first 0
        //return as long

        //if negative
        // sort the char array
        //reverse the char array
        //return as long

        if(num ==0){
            return 0;
        }

        boolean isNegative = num < 0;

        long res  = 0;
        num = Math.abs(num);

        char[] ch = String.valueOf(num).toCharArray();
        Arrays.sort(ch);

        if(isNegative){
            String str = "";
            for(int i = ch.length-1; i>=0 ; i--){
                str+=ch[i];
            }
            res = -Long.parseLong(str);
        }
        else{
            int i = 0;
            for( ; i <ch.length; i++){
                if(ch[i] != '0'){
                    break;
                }
            }

            //swap 0 with the first non zero character
            if(i <= ch.length-1){
                char temp = ch[i];
                ch[i]= ch[0];
                ch[0]= temp;
            }

            String str = String.valueOf(ch);
            res = Long.parseLong(str);
        }
        return res;
    }
}

// TC: O(nlogn)
// SC: O(1)