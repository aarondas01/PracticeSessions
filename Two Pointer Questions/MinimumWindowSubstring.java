class Solution {
    public String minWindow(String s, String t) {

        String ans ="";
        HashMap<Character,Integer> tmap = new HashMap<>();

        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        int matchCount  = 0 ;
        int desiredMatchCount = t.length();

        HashMap<Character,Integer> smap = new HashMap<>();
        int i = -1, j =-1;

        while(true){
            boolean flag1 = false, flag2 = false;
            //acquire
            while( i < s.length()-1 && matchCount < desiredMatchCount){
                i++;
                char ch = s.charAt(i);
                smap.put(ch,smap.getOrDefault(ch,0)+1);

                if(smap.getOrDefault(ch,0) <= tmap.getOrDefault(ch,0)){
                    matchCount++;
                }
                flag1 = true;

            }
            //compare with desired match count
            //release and collect answers

            while(j < i  && matchCount == desiredMatchCount){
                //str is potential answer
                String str = s.substring(j+1,i+1);
                if(ans.length() == 0 || str.length() < ans.length()){
                    ans = str;
                }
                j++;
                char ch2 = s.charAt(j);
                if(smap.get(ch2) == 1){
                    smap.remove(ch2);
                }
                else{
                    smap.put(ch2, smap.get(ch2)-1);
                }

                if(smap.getOrDefault(ch2,0) < tmap.getOrDefault(ch2,0)){
                    matchCount--;
                }
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return ans;
    }
}

// TC: O(n)
// SC: O(n)