class Solution {
    public boolean isValidSerialization(String preorder) {
        //create a vacancy variable with initial value 1
        // when you encounter a number delete one vacancy and add two vacancy
        // when you encounter a # delete one vacancy
        //if vacancy at any point becomes < 0  its not valid serialization

        String[] strs = preorder.split(",");
        int vacancy = 1;
        for(String str : strs){
            vacancy--;
            if(vacancy <0){
                return false;
            }
            if(!str.equals("#")){
                vacancy +=2;
            }

        }
        return vacancy == 0;
    }
}
// TC: O(n)
// SC: O(n)