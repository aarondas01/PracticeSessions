class Solution {
    public char findTheDifference(String s, String t) {
        //bit manipulation
        char res = 0;
        for(char c: s.toCharArray()){
            res ^= c;
        }
        for(char c : t.toCharArray()){
            res ^= c;
        }
        return res;
    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        int i = 0 , j =0;

        while( i < s.length()){
            if(s1[i] != t1[j]){
                return t1[j];
            }
            i++;
            j++;
        }
        return t1[t.length()-1];

    }
}

// TC: O(nlogn)
// SC: O(n)


class Solution {
    public char findTheDifference(String s, String t) {
        int c1 =0, c2 =0;
        for(char c : s.toCharArray()){
            c1 +=c;
        }
        for(char c: t.toCharArray()){
            c2 +=c;
        }
        return (char)(c2-c1);
    }
}

// TC: O(n)
// SC: O(1)