class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int i= 0;
        while(i < s.length()){

            char ch = s.charAt(i);
            int startIndex  = i ;
            int endIndex = s.lastIndexOf(ch);

            for(int j = startIndex+1; j <= endIndex; j++){
                //last occurence of next character
                endIndex = Math.max(endIndex, s.lastIndexOf(s.charAt(j)));
            }
            partitions.add(endIndex-startIndex+1);
            i = endIndex+1;
        }
        return partitions;
    }
}
// TC: O(N)
// SC: O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        //brute force
        int startIndex  =0;
        int endIndex = 0 ;

        List<Integer> partitions = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            for(int j =  endIndex+1; j< s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    endIndex = j;
                }
            }
            if(i == endIndex){
                partitions.add(endIndex-startIndex+1);
                endIndex++;
                startIndex = endIndex;
            }
        }
        return partitions;
    }
}
// TC: O(N^2)
// SC: O(1)