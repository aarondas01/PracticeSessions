class Solution {
    public String minimizeResult(String expression) {
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        int plus = -1;

        char[] str = expression.toCharArray();

        for(int i= 0 ; i < str.length; i++){
            if(str[i] == '+'){
                plus = i;
                break;
            }
        }


        for(int i = 0 ; i < plus; i++){
            for(int j = plus +1 ; j < expression.length(); j++ ){
                int n1 = 1;
                String n1Str = expression.substring(0,i);

                if(n1Str.length() > 0){
                    n1 =Integer.parseInt(n1Str);
                }

                String n2Str = expression.substring(i,plus);
                int n2 = Integer.parseInt(n2Str);

                String n3Str = expression.substring(plus+1, j+1);
                int n3 = Integer.parseInt(n3Str);

                int n4 =1;
                String n4Str = expression.substring(j+1);
                if(n4Str.length() > 0){
                    n4 = Integer.parseInt(n4Str);
                }

                int val = n1*(n2+n3)*n4;
                if(val < min){
                    min = val;
                    left = i;
                    right = j+1;

                }
            }
        }

        String ans ="";
        ans += expression.substring(0,left);
        ans += "(";
        ans += expression.substring(left,right);
        ans += ")";
        ans += expression.substring(right);

        return ans;

    }
}

// TC: O(n)
// SC: O(n)