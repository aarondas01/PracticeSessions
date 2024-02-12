class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length-1];

        int index =0 ;

        while(index < s1.length() && index < s2.length()){
            if(s1.charAt(index) ==  s2.charAt(index)){
                index++;
            }
            else{
                break;
            }
        }

        return s1.substring(0,index);
    }
}

// TC: O(nlogn)
// SC: O(1)


class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(int index =1; index < strs.length; index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
// TC: O(n)
// SC: O(1)
