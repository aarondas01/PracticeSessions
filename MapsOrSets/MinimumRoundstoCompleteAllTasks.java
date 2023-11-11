class Solution {
    public int minimumRounds(int[] tasks) {
        //using Map
        //greedy to minimize
        // <task,count>
        Map<Integer, Integer> map = new HashMap<>();
        int count  = 0 ;

        for(int n : tasks){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(int k : map.values()){
            if(k == 1){
                return -1;
            }
            if(k %3 !=0){
                count += (k/3) +1;
            }
            else{
                count += k/3;
            }
        }
        return count;
    }
}

// TC: O(n)
// SC: O(n)