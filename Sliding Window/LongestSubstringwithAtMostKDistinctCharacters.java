public static int longestSubstringwithAtmostKDistinct(String str, int k){

        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();

        boolean f1 = false, f2 = false;

        while(true){
            while(i < str.length()-1){
                f1= true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch,0)+1);

                if(map.size()<=k){
                    int len = i-j;
                    if(len > ans){
                        ans =len;
                    }
                    else{
                        break;
                    }
                }
                while(j < i){
                    f2 = true;
                    j++;
                    char ch = str.charAt(j);
                    if(map.get(ch) == 1){
                        map.remove(ch);
                        }
                    else{
                        map.put(ch, map.get(ch)-1);
                        }
                    if(map.size()> k){
                        continue;
                        }
                    else{
                        int len = i-j;
                        if(len > ans){
                            ans =len;
                        }
                        break;
                     }

                    }
                if(f1 == false && f2 == false){
                    break;
                    }

            }
        }
        return ans;
        }
//TC: O(n)
//SC: O(n)

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String S, int K) {
        int[] charCount = new int[256];
        char[] chS = S.toCharArray();
        int distinctNum = 0, leftIndex = 0, maxLen = 0;
        for (int rightIndex = 0; rightIndex < chS.length; rightIndex++) {
            if (charCount[chS[rightIndex]]++ == 0) distinctNum++;
            if (distinctNum > K) {
                while (--charCount[chS[leftIndex++]] > 0);
                distinctNum--;
            }
            maxLen = Math.max(maxLen, rightIndex - leftIndex + 1);
        }
        return maxLen;
    }
}

//TC: O(n)
//    SC: O(k)