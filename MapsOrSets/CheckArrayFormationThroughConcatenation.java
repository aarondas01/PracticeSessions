class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //using Map
        Map<Integer,int[]> map = new HashMap<>();

        for(int[] piece : pieces){
            map.put(piece[0], piece);
        }

        int start = 0 ;
        while(start < arr.length){
            if(map.containsKey(arr[start])){
                int[] piece = map.get(arr[start]);
                for(int i = 0 ; i < piece.length; i++){
                    if(arr[start] != piece[i]){
                        return false;
                    }
                    else{
                        start++;
                    }
                }

            }
            else{
                return false;
            }
        }
        return true;
    }
}

// TC: O(n)
// SC: O(1)