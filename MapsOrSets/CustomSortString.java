class Solution {
    public String customSortString(String order, String s) {
        //using frequency map

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder str = new StringBuilder();
        for(char ch : order.toCharArray()){
            while(freq[ch-'a']>0){
                str.append(ch);
                freq[ch-'a']--;
            }
        }

        for(int i = 0 ; i < 26; i++){
            int freqCh = freq[i];
            while(freqCh>0){
                str.append((char)(i+'a'));
                freqCh--;
            }
        }
        return str.toString();
    }
}

// TC: O(m+n)
// SC: O(1)