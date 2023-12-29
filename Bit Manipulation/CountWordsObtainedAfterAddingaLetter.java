class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        //using sorting
        Set<String> set = new HashSet<>();
        for(String s : startWords){
            char[] charStr = s.toCharArray();
            Arrays.sort(charStr);
            set.add(new String(charStr));
        }

        int count = 0;
        for(String t : targetWords){
            int n = t.length();
            for(int i = 0 ; i < n ; i++){
                String reducedStr = t.substring(0,i) + t.substring(i+1);
                char[] charStr = reducedStr.toCharArray();
                Arrays.sort(charStr);
                String sortedStr = new String(charStr);
                if(set.contains(sortedStr)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        //using bit masking

        int res =0;
        Set<Integer> set = new HashSet<>();
        for(String word : startWords){
            set.add(bitmask(word));
        }

        for(String word: targetWords){
            int bitmask = bitmask(word);
            for(char c : word.toCharArray()){
                if(set.contains(bitmask - (1 << c - 'a'))){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    private int bitmask(String word){
        int count = 0;
        for(char c : word.toCharArray()){
            count += 1 << c -'a';
        }
        return count;
    }
}

// TC: O(N)
// SC: O(N)