class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //sorting
        // [0,1] 0 = num of soldier 1 = index of row
        //maxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] != b[0] ? b[0]-a[0] : b[1]-a[1]));
        int[] res = new int[k];

        for(int i = 0 ; i < mat.length; i++){
            int soldier = 0;
            for(int j = 0 ; j < mat[0].length; j++){
                if(mat[i][j] ==1){
                    soldier++;
                }
                else{
                    break;
                }
            }
            pq.add(new int[]{soldier,i});
        }
        while(pq.size() >k){
            pq.poll();
        }

        while(k >0){
            res[--k] = pq.poll()[1];
        }
        return res;
    }
}

// TC: O(logk * logn)
// SC: O(n)