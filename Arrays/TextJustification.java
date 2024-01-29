class Solution {


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int n = words.length;
        int i = 0 ;

        while(i < n){
            int lettersCount = words[i].length();

            int j = i+1;

            int spaceSlots  = 0;

            while(j < n && spaceSlots+ lettersCount + words[j].length()+1 <= maxWidth){
                lettersCount += words[j].length();
                spaceSlots +=1;
                j++;
            }

            int remainingSlots = maxWidth - lettersCount;

            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots/spaceSlots;
            int extraSpace = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            //for last line only left justified
            if(j == n){
                eachWordSpace = 1;
                extraSpace = 0;
            }

            result.add(getFinalWord(i, j , eachWordSpace, extraSpace, words, maxWidth));
            i = j;
        }
        return result;
    }


    private String getFinalWord(int i , int j , int eachWordSpace, int extraSpace, String[] words, int maxWidth ){
        StringBuilder str = new StringBuilder();

        for(int k = i ; k < j ; k++){
            str.append(words[k]);

            //last word of line - no space after last word of line
            //all spaces are exhausted at this point
            if(k == j-1){
                continue;
            }
            for(int space  =1; space <= eachWordSpace; space++){
                str.append(" ");
            }

            if(extraSpace > 0){
                str.append(" ");
                extraSpace--;
            }

        }

        while(str.length() < maxWidth){
            str.append(" ");
        }
        return str.toString();
    }
}

// TC: O(n*each word length + spaces)
//SC: (words*eachWordLength + spaces)
