class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //using priority queue

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (b-a));
        for(int i=0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                pq.offer(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}

// TC: O(nlogk)
// SC : O(k)


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //using binary search
        int  n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low < high){
            int mid = low + (high-low)/2;

            //find the rank of the element
            int count = count(matrix, mid);
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    //binary search is done on range not on indexes
    //find the rank of the element
    private int count(int[][] matrix, int mid){
        int n = matrix.length;

        int row = 0 , col = n-1;
        int count  = 0;
        while(row< n && col >=0){
            if(matrix[row][col] >mid){
                col--;
            }
            else{
                count += col+1;
                row++;
            }
        }
        return count;
    }
}

// TC: O(min(m,n) log(max-min))
// SC O(1)