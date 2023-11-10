class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] occupancy = new int[1001];

        for(int i = 0 ; i < trips.length; i++){
            occupancy[trips[i][1]] += trips[i][0];
            occupancy[trips[i][2]] -= trips[i][0];
        }

        int currCapacity = 0;
        for(int currOccupancy : occupancy){
            currCapacity += currOccupancy;
            if(currCapacity > capacity){
                return false;
            }
        }
        return true;

    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //using Priority Queue and sorting
        int n = trips.length;
        if(n==0)
            return true;

        Arrays.sort(trips, (trip1,trip2)->trip1[1]-trip2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        int count  = 0;

        for(int[] trip : trips){
            int passengers = trip[0];
            int pickup = trip[1];
            int destination = trip[2];

            while(!pq.isEmpty() && pq.peek()[0] <= pickup){
                count -= pq.poll()[1];
            }

            pq.add(new int[]{destination,passengers});
            count += passengers;
            if(count > capacity){
                return false;
            }
        }
        return true;
    }
}

// TC: O(nlogn)
// SC: O(n)